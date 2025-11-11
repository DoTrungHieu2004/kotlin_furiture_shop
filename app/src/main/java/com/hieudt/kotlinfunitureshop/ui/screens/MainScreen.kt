package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.navigation.NavItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Danh sách item
    val items = listOf(
        NavItem("home", "Home", painterResource(R.drawable.ic_home)),
        NavItem("favourites", "Favourites", painterResource(R.drawable.ic_bookmark_outline)),
        NavItem("notifications", "Notifications", painterResource(R.drawable.ic_notifications_outline)),
        NavItem("profile", "Profile", painterResource(R.drawable.ic_person_outline))
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentDestination = navController.currentBackStackEntryAsState().value?.destination
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.route == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = item.icon,
                                contentDescription = item.label
                            )
                        },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { PlaceholderScreen("Home") }
            composable("favorites") { PlaceholderScreen("Favourites") }
            composable("notifications") { PlaceholderScreen("Notifications") }
            composable("profile") { PlaceholderScreen("Profile") }
        }
    }
}

@Composable
fun PlaceholderScreen(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}