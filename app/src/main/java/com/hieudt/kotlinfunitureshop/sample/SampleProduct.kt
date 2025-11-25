package com.hieudt.kotlinfunitureshop.sample

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hieudt.kotlinfunitureshop.R

data class SampleProduct (
    val id: String,
    val name: String,
    val price: Double,
    @DrawableRes val image: Int,
    val description: String
) {
    companion object {
        @Composable
        fun getSampleProducts() = listOf(
            SampleProduct(
                id = "A01",
                name = "Black Simple Lamp",
                price = 12.00,
                image = R.drawable.product_example,
                description = stringResource(R.string.lorem_ipsum)
            ),
            SampleProduct(
                id = "A02",
                name = "Minimal Stand",
                price = 25.00,
                image = R.drawable.product_example,
                description = stringResource(R.string.lorem_ipsum)
            )
        )
    }
}