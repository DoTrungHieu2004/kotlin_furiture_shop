package com.hieudt.kotlinfunitureshop.api

import com.hieudt.kotlinfunitureshop.api.requests.AddressRequest
import com.hieudt.kotlinfunitureshop.api.requests.LoginRequest
import com.hieudt.kotlinfunitureshop.api.requests.RegisterRequest
import com.hieudt.kotlinfunitureshop.api.requests.UpdateUserRequest
import com.hieudt.kotlinfunitureshop.api.responses.AddressResponse
import com.hieudt.kotlinfunitureshop.api.responses.AuthResponse
import com.hieudt.kotlinfunitureshop.api.responses.UserResponse
import com.hieudt.kotlinfunitureshop.data.models.Category
import com.hieudt.kotlinfunitureshop.data.models.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIService {

    // User routes
    @POST("api/users/register")
    suspend fun register(@Body req: RegisterRequest): AuthResponse

    @POST("api/users/login")
    suspend fun login(@Body req: LoginRequest): AuthResponse

    @GET("api/users/me")
    suspend fun getProfile(): UserResponse

    @PUT("api/users/update")
    suspend fun updateUser(@Body req: UpdateUserRequest): UserResponse

    @POST("api/users/address")
    suspend fun addAddress(@Body req: AddressRequest): AddressResponse

    @DELETE("api/users/address/{id}")
    suspend fun deleteAddress(@Path("id") id: String): AddressResponse

    // Product routes
    @GET("api/products")
    suspend fun getProducts(): List<Product>

    @GET("api/products/category/{id}")
    suspend fun getProductByCategory(
        @Path("id") id: String
    ): List<Product>

    @GET("api/products/{id}")
    suspend fun getProduct(
        @Path("id") id: String
    ): Product

    // Category routes
    @GET("api/categories")
    suspend fun getCategories(): List<Category>
}