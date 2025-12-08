package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.hieudt.kotlinfunitureshop.ui.navigation.BottomNavBar
import com.hieudt.kotlinfunitureshop.ui.navigation.Graph
import com.hieudt.kotlinfunitureshop.ui.navigation.Screen
import com.hieudt.kotlinfunitureshop.ui.screens.fragments.FavoriteFragment
import com.hieudt.kotlinfunitureshop.ui.screens.fragments.HomeFragment
import com.hieudt.kotlinfunitureshop.ui.screens.fragments.NotificationFragment
import com.hieudt.kotlinfunitureshop.ui.screens.fragments.ProfileFragment

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Danh sách item
    val bottomDestinations = listOf(
        Screen.Home.route,
        Screen.Favorites.route,
        Screen.Notifications.route,
        Screen.Profile.route
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomDestinations) {
                BottomNavBar(navController)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Graph.BOTTOM,
            modifier = Modifier.padding(it)
        ) {
            bottomNavGraph(navController)
            noBottomNavGraph(navController)
        }
    }
}

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = Graph.BOTTOM
    ) {
        composable(Screen.Home.route) {
            HomeFragment(
                onProductClick = { id ->
                    navController.navigate(Screen.ProductInfo.createRoute(id))
                }
            )
        }

        composable(Screen.Favorites.route) {
            FavoriteFragment()
        }

        composable(Screen.Notifications.route) {
            NotificationFragment()
        }

        composable(Screen.Profile.route) {
            ProfileFragment()
        }
    }
}

fun NavGraphBuilder.noBottomNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.ProductInfo.route,
        route = Graph.NO_BOTTOM
    ) {
        composable(
            route = Screen.ProductInfo.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStack ->
            val id = backStack.arguments?.getString("id")!!
            ProductInfoScreen(
                productId = id,
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}