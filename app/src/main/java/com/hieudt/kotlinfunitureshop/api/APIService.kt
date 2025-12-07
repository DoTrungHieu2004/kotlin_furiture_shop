package com.hieudt.kotlinfunitureshop.api

import com.hieudt.kotlinfunitureshop.api.requests.AddressRequest
import com.hieudt.kotlinfunitureshop.api.requests.LoginRequest
import com.hieudt.kotlinfunitureshop.api.requests.RegisterRequest
import com.hieudt.kotlinfunitureshop.api.requests.UpdateUserRequest
import com.hieudt.kotlinfunitureshop.api.responses.AddressResponse
import com.hieudt.kotlinfunitureshop.api.responses.AuthResponse
import com.hieudt.kotlinfunitureshop.api.responses.UserResponse
import com.hieudt.kotlinfunitureshop.data.models.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIService {

    // User routes
    @POST("users/register")
    suspend fun register(@Body req: RegisterRequest): AuthResponse

    @POST("users/login")
    suspend fun login(@Body req: LoginRequest): AuthResponse

    @GET("users/me")
    suspend fun getProfile(): UserResponse

    @PUT("users/update")
    suspend fun updateUser(@Body req: UpdateUserRequest): UserResponse

    @POST("users/address")
    suspend fun addAddress(@Body req: AddressRequest): AddressResponse

    @DELETE("users/address/{id}")
    suspend fun deleteAddress(@Path("id") id: String): AddressResponse

    // Product routes
    @GET("products")
    suspend fun getProducts(): List<Product>
}