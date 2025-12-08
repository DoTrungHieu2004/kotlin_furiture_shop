package com.hieudt.kotlinfunitureshop.viewmodel.providers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.hieudt.kotlinfunitureshop.AppApplication
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.repositories.ProductRepository
import com.hieudt.kotlinfunitureshop.viewmodel.ProductDetailViewModel

@Composable
fun provideProductDetailViewModel(): ProductDetailViewModel {

    val tokenStorage = AppApplication.tokenStorage
    val api = remember { APIClient.create { tokenStorage.getToken().toString() } }
    val repo = remember { ProductRepository(api) }

    return remember { ProductDetailViewModel(repo) }
}