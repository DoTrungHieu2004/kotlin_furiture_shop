package com.hieudt.kotlinfunitureshop.data.repositories

import com.hieudt.kotlinfunitureshop.api.APIService

class ProductRepository(private val api: APIService) {
    suspend fun getProducts() = api.getProducts()
}