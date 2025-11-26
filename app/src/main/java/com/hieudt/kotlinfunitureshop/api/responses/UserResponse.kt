package com.hieudt.kotlinfunitureshop.api.responses

import com.hieudt.kotlinfunitureshop.data.models.User

data class UserResponse(
    val message: String?,
    val user: User
)