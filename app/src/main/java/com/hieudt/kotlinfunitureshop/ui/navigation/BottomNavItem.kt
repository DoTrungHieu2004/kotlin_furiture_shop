package com.hieudt.kotlinfunitureshop.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hieudt.kotlinfunitureshop.R

sealed class BottomNavItem(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavItem("home", R.string.nav_home, R.drawable.ic_home)
    object Favourites : BottomNavItem("favourites", R.string.nav_favourites, R.drawable.ic_bookmark_outline)
    object Notifications : BottomNavItem("notifications", R.string.nav_notifications, R.drawable.ic_notifications_outline)
    object Profile : BottomNavItem("profile", R.string.nav_profile, R.drawable.ic_person_outline)
}