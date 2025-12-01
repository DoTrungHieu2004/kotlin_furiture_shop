package com.hieudt.kotlinfunitureshop.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.repositories.AuthRepository
import com.hieudt.kotlinfunitureshop.utils.TokenStorage

@Composable
fun provideAuthViewModel(): AuthViewModel {
    val context = LocalContext.current

    val tokenStorage = remember { TokenStorage(context) }
    val apiService = remember { APIClient.create { tokenStorage.getToken() } }
    val repository = remember { AuthRepository(apiService, tokenStorage) }

    return remember { AuthViewModel(repository) }
}