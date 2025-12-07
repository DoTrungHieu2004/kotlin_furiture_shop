package com.hieudt.kotlinfunitureshop.viewmodel.providers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.hieudt.kotlinfunitureshop.AppApplication
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.repositories.ProductRepository
import com.hieudt.kotlinfunitureshop.viewmodel.ProductViewModel

@Composable
fun provideProductViewModel(): ProductViewModel {

    val tokenStorage = AppApplication.tokenStorage
    val apiService = remember { APIClient.create { tokenStorage.getToken().toString() } }
    val repository = remember { ProductRepository(apiService) }

    return remember { ProductViewModel(repository) }
}