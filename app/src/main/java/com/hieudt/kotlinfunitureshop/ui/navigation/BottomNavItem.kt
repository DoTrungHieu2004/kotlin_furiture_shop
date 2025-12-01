package com.hieudt.kotlinfunitureshop.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hieudt.kotlinfunitureshop.R

data class BottomNavItem(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int? = null
)