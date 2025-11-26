package com.hieudt.kotlinfunitureshop.api.requests

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String?
)