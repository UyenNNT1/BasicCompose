package com.example.basestatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.basestatecodelab.data.ToolModel
import com.example.basestatecodelab.ui.account.AccountScreen
import com.example.basestatecodelab.ui.face.FaceScreen
import com.example.basestatecodelab.ui.home.HomeScreen
import com.example.basestatecodelab.ui.home.HomeViewModel
import com.example.basestatecodelab.ui.home.widgets.BottomNavigation
import com.example.basestatecodelab.ui.navigation.NavRoutes
import com.example.basestatecodelab.ui.theme.BaseStateCodelabTheme
import com.example.basestatecodelab.ui.tool.ToolDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseStateCodelabTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val viewModel: HomeViewModel = viewModel()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigation(navController, currentRoute = currentRoute) }
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.BottomScreen.HomeScreen.bRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        addHomeScreen(navController, this, viewModel)
                        addFaceScreen(navController, this)
                        addAccountScreen(navController, this)
                        addToolDetailScreen(navController, this)
                    }
                }
            }
        }
    }

}

fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: HomeViewModel
) {
    navGraphBuilder.composable(route = NavRoutes.BottomScreen.HomeScreen.bRoute) {
        HomeScreen(viewModel = viewModel,
            navigationToToolDetail = { tool ->
                navController.navigate("${NavRoutes.ToolDetailScreen.route}/${tool.toGson()}")
            })
    }
}


private fun addAccountScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoutes.BottomScreen.FaceScreen.bRoute) {
        FaceScreen()
    }
}

private fun addFaceScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoutes.BottomScreen.AccountScreen.bRoute) {
        AccountScreen()
    }
}

private fun addToolDetailScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = "${NavRoutes.ToolDetailScreen.route}/{toolJson}") {
        val toolJson = it.arguments?.getString("toolJson")
        val tool = ToolModel.fromGson(toolJson ?: "")
        ToolDetailScreen(tool, navController)
    }
}


