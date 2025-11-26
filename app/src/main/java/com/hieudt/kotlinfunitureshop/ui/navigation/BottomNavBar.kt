package com.hieudt.kotlinfunitureshop.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.hieudt.kotlinfunitureshop.R

@Composable
fun BottomNavBar(navController: NavHostController) {
    NavigationBar {
        val items = listOf(
            Screen.Home,
            Screen.Favorites,
            Screen.Notifications,
            Screen.Profile
        )

        val currentRoute = navController.currentDestination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(Graph.BOTTOM) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = item.route
                    )
                },
                label = {
                    Text(text = item.route)
                }
            )
        }
    }
}