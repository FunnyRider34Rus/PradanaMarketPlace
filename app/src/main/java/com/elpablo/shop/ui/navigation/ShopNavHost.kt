package com.elpablo.shop.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elpablo.shop.ui.screens.ScreenSignIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopNavHost(
    navController: NavHostController,
    startDestination: String
) {
    Scaffold { paddingValue ->
        NavHost(
            modifier = Modifier.padding(paddingValue),
            navController = navController,
            startDestination = startDestination,
            route = Graph.NAVGRAPH.route
        ) {
            composable(route = Screen.SignIn.route) {
                ScreenSignIn(modifier = Modifier)
            }
        }
    }

}

sealed class Screen(val route: String) {
    object SignIn : Screen(route = "sign_in")
    object WelcomeBack : Screen(route = "welcome_back")
    object Profile : Screen(route = "profile")
    object Dashboard : Screen(route = "dashboard")
    object Detail : Screen(route = "detail")
}
sealed class Graph(val route: String) {
    object NAVGRAPH : Graph("root_nav_graph")
}