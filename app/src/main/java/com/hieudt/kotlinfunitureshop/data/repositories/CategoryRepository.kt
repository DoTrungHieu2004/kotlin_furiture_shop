package com.hieudt.kotlinfunitureshop.data.repositories

import com.hieudt.kotlinfunitureshop.api.APIService

class CategoryRepository(private val api: APIService) {
    suspend fun getCategories() = api.getCategories()
}