package com.hieudt.kotlinfunitureshop.data.models

data class User(
    val _id: String,
    val name: String,
    val email: String,
    val phone: String?,
    val addresses: List<Address>?,
    val avatar: String?,
    val role: String
)