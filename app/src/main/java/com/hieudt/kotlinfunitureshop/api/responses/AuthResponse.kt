package com.hieudt.kotlinfunitureshop.api.responses

import com.hieudt.kotlinfunitureshop.data.models.User

data class AuthResponse(
    val message: String,
    val token: String,
    val user: User
)