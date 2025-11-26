package com.hieudt.kotlinfunitureshop.api.responses

import com.hieudt.kotlinfunitureshop.data.models.Address

data class AddressResponse(
    val message: String,
    val addresses: List<Address>
)