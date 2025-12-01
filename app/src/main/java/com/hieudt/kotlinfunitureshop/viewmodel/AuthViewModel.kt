package com.hieudt.kotlinfunitureshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hieudt.kotlinfunitureshop.api.requests.RegisterRequest
import com.hieudt.kotlinfunitureshop.data.repositories.AuthRepository
import com.hieudt.kotlinfunitureshop.viewmodel.state.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState = _authState.asStateFlow()

    /** ĐĂNG NHẬP **/
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                val user = repository.login(email, password)
                _authState.value = AuthState.Success(user)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Lỗi không xác định")
            }
        }
    }

    /** ĐĂNG KÝ **/
    fun register(
        name: String,
        email: String,
        password: String,
        phone: String?
    ) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                val user = repository.register(
                    RegisterRequest(
                        name = name,
                        email = email,
                        password = password,
                        phone = phone
                    )
                )
                _authState.value = AuthState.Success(user)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Lỗi không xác định")
            }
        }
    }

    /** Reset state khi rời màn hình **/
    fun resetState() {
        _authState.value = AuthState.Idle
    }
}