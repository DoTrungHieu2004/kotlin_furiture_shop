package com.hieudt.kotlinfunitureshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.hieudt.kotlinfunitureshop.ui.screens.LoginScreen
import com.hieudt.kotlinfunitureshop.ui.screens.RegisterScreen
import com.hieudt.kotlinfunitureshop.ui.screens.WelcomeScreen
import com.hieudt.kotlinfunitureshop.ui.screens.bottomNavGraph
import com.hieudt.kotlinfunitureshop.ui.screens.noBottomNavGraph

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Graph.AUTH
    ) {
        authGraph(navController)
        appGraph(navController)
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onGettingStarted = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Graph.APP) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Graph.APP) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }
            )
        }
    }
}

fun NavGraphBuilder.appGraph(navController: NavHostController) {
    navigation(
        route = Graph.APP,
        startDestination = Graph.BOTTOM
    ) {
        bottomNavGraph(navController)
        noBottomNavGraph(navController)
    }
}