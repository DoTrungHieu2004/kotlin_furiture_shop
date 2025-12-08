package com.hieudt.kotlinfunitureshop.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hieudt.kotlinfunitureshop.data.models.Category
import com.hieudt.kotlinfunitureshop.data.repositories.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val repo: CategoryRepository): ViewModel() {
    var categories by mutableStateOf<List<Category>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        loadCategories()
    }

    fun loadCategories() {
        viewModelScope.launch {
            try {
                isLoading = true
                categories = repo.getCategories()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }
}