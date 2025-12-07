package com.hieudt.kotlinfunitureshop.viewmodel.providers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.hieudt.kotlinfunitureshop.AppApplication
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.repositories.AuthRepository
import com.hieudt.kotlinfunitureshop.viewmodel.AuthViewModel

@Composable
fun provideAuthViewModel(): AuthViewModel {

    val tokenStorage = AppApplication.tokenStorage
    val apiService = remember { APIClient.create { tokenStorage.getToken().toString() } }
    val repository = remember { AuthRepository(apiService, tokenStorage) }

    return remember { AuthViewModel(repository) }
}