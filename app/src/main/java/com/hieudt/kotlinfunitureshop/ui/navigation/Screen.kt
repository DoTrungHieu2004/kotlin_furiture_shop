package com.hieudt.kotlinfunitureshop.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Register : Screen("register")

    // Các fragment bottom nav
    object Home : Screen("home")
    object Favorites : Screen("favorites")
    object Notifications : Screen("notifications")
    object Profile : Screen("profile")

    // Các màn hình khác
    object ProductInfo : Screen("product_info/{id}") {
        val routeWithArg = "product_info/{id}"

        fun createRoute(id: String) = "product_info/$id"
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val APP = "app_graph"
    const val BOTTOM = "bottom_graph"
    const val NO_BOTTOM = "no_bottom_graph"
}