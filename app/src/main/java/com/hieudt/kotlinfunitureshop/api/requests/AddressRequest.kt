package com.hieudt.kotlinfunitureshop.api.requests

data class AddressRequest(
    val label: String,
    val address: String,
    val isDefault: Boolean
)