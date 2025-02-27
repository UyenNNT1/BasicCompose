package com.example.basestatecodelab.ui.home.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.basestatecodelab.ui.navigation.NavRoutes

@Composable
fun BottomNavigation(navController: NavController, currentRoute: String?) {
    if (currentRoute == null) return
    val screens = listOf(
        NavRoutes.BottomScreen.HomeScreen,
        NavRoutes.BottomScreen.FaceScreen,
        NavRoutes.BottomScreen.AccountScreen
    )
    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.bTitle) },
                label = { Text(screen.bTitle) },
                selected = currentRoute == screen.bRoute,
                onClick = {
                    if (currentRoute != screen.bRoute) {
                        navController.navigate(screen.bRoute) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}
