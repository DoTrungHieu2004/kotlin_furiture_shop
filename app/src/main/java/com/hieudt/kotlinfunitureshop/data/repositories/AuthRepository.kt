package com.hieudt.kotlinfunitureshop.data.repositories

import com.hieudt.kotlinfunitureshop.api.APIService
import com.hieudt.kotlinfunitureshop.api.requests.AddressRequest
import com.hieudt.kotlinfunitureshop.api.requests.LoginRequest
import com.hieudt.kotlinfunitureshop.api.requests.RegisterRequest
import com.hieudt.kotlinfunitureshop.data.models.User
import com.hieudt.kotlinfunitureshop.utils.TokenStorage

class AuthRepository(
    private val api: APIService,
    private val storage: TokenStorage
) {
    suspend fun login(email: String, password: String): User {
        val res = api.login(LoginRequest(email, password))
        storage.saveToken(res.token)
        return res.user
    }

    suspend fun register(request: RegisterRequest): User {
        val res = api.register(request)
        storage.saveToken(res.token)
        return res.user
    }

    suspend fun getProfile() = api.getProfile().user

    suspend fun addAddress(req: AddressRequest) = api.addAddress(req).addresses

    suspend fun deleteAddress(id: String) = api.deleteAddress(id).addresses
}