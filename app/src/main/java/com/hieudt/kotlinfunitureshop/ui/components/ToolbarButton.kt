package com.hieudt.kotlinfunitureshop.ui.components

import androidx.annotation.DrawableRes

data class ToolbarButton(
    @DrawableRes val iconRes: Int,
    val contentDescription: String? = null,
    val onClick: () -> Unit
)