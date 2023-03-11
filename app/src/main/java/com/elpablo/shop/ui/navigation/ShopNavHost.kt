package com.elpablo.shop.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elpablo.shop.ui.screens.login.ScreenLogin
import com.elpablo.shop.ui.screens.profile.ScreenProfile
import com.elpablo.shop.ui.screens.signin.ScreenSignIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopNavHost(
    navController: NavHostController,
    startDestination: String
) {
    Scaffold { paddingValue ->
        val modifier = Modifier.padding(paddingValue)
        NavHost(
            navController = navController,
            startDestination = startDestination,
            route = Graph.NAVGRAPH.route
        ) {
            composable(route = Screen.SignIn.route) {
                ScreenSignIn(navController = navController, modifier = modifier)
            }

            composable(route = Screen.Login.route) {
                ScreenLogin(navController = navController, modifier = modifier)
            }

            composable(route = Screen.Profile.route) {
                ScreenProfile(navController = navController, modifier = modifier)
            }
        }
    }

}

sealed class Screen(val route: String) {
    object SignIn : Screen(route = "sign_in")
    object Login : Screen(route = "login")
    object Profile : Screen(route = "profile")
    object Dashboard : Screen(route = "dashboard")
    object Detail : Screen(route = "detail")
}
sealed class Graph(val route: String) {
    object NAVGRAPH : Graph("root_nav_graph")
}