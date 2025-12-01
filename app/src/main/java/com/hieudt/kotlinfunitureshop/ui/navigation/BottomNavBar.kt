package com.hieudt.kotlinfunitureshop.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hieudt.kotlinfunitureshop.R

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem(
            "home",
            R.string.nav_home,
            R.drawable.ic_home,
            R.drawable.ic_home_outline
        ),
        BottomNavItem(
            "favorites",
            R.string.nav_favourites,
            R.drawable.ic_bookmark,
            R.drawable.ic_bookmark_outline
        ),
        BottomNavItem(
            "notifications",
            R.string.nav_notifications,
            R.drawable.ic_notifications,
            R.drawable.ic_notifications_outline
        ),
        BottomNavItem(
            "profile",
            R.string.nav_profile,
            R.drawable.ic_person,
            R.drawable.ic_person_outline
        )
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(Graph.BOTTOM) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (selected && item.selectedIcon != null) {
                                item.selectedIcon
                            } else {
                                item.icon
                            }
                        ),
                        contentDescription = item.title.toString()
                    )
                },
                label = {
                    Text(text = item.route)
                }
            )
        }
    }
}