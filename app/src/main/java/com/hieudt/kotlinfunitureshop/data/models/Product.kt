package com.hieudt.kotlinfunitureshop.data.models

data class Product(
    val _id: String,
    val name: String,
    val description: String,
    val price: Double,
    val discount: Double,
    val image: String,
    val categoryId: Category,
    val stock: Int
)