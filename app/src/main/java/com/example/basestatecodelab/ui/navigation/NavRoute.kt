package com.example.basestatecodelab.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavRoutes(val route: String) {
    object CategoryDetailScreen : NavRoutes("category_screen")
    object ToolDetailScreen : NavRoutes("tool_screen/{jsonTool}")


    sealed class BottomScreen(val bRoute: String, val bTitle: String, val icon: ImageVector) :
        NavRoutes(route = bRoute) {
        object HomeScreen : BottomScreen("home_screen", "Home", Icons.Default.Home)
        object FaceScreen : BottomScreen("face_screen", "Face", Icons.Default.Face)
        object AccountScreen : BottomScreen("account_screen", "Account", Icons.Default.AccountCircle)
    }
}
