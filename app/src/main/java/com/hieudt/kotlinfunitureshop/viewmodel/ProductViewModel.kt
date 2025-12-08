package com.hieudt.kotlinfunitureshop.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hieudt.kotlinfunitureshop.data.models.Product
import com.hieudt.kotlinfunitureshop.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repo: ProductRepository
): ViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            try {
                isLoading = true
                error = null

                val result = repo.getProducts()
                products = result
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun loadProductsByCategory(categoryId: String) {
        viewModelScope.launch {
            try {
                isLoading = true
                products = repo.getProductsByCategory(categoryId)
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }
}