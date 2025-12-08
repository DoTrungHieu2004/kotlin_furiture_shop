package com.hieudt.kotlinfunitureshop.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hieudt.kotlinfunitureshop.data.models.Product
import com.hieudt.kotlinfunitureshop.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val repo: ProductRepository): ViewModel() {
    var product by mutableStateOf<Product?>(null)
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun loadProductDetail(id: String) {
        viewModelScope.launch {
            try {
                isLoading = true
                product = repo.getProduct(id)
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }
}