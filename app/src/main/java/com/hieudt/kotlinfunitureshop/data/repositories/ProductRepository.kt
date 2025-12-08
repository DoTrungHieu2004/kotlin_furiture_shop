package com.hieudt.kotlinfunitureshop.data.repositories

import com.hieudt.kotlinfunitureshop.api.APIService

class ProductRepository(private val api: APIService) {
    suspend fun getProducts() = api.getProducts()

    suspend fun getProductsByCategory(categoryId: String) = api.getProductByCategory(categoryId)

    suspend fun getProduct(id: String) = api.getProduct(id)
}