package com.hieudt.kotlinfunitureshop.viewmodel.state

import com.hieudt.kotlinfunitureshop.data.models.User

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()

    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
}