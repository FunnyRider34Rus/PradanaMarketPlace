package com.elpablo.shop.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elpablo.shop.core.components.BottomBar
import com.elpablo.shop.ui.screens.login.ScreenLogin
import com.elpablo.shop.ui.screens.page1.ScreenPage1
import com.elpablo.shop.ui.screens.profile.ScreenProfile
import com.elpablo.shop.ui.screens.signin.ScreenSignIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopNavHost(
    navController: NavHostController,
    startDestination: String
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValue ->
        val modifier = Modifier.padding(paddingValue)
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = Screen.SignIn.route) {
                Log.d("navbar", "screen.signin")
                ScreenSignIn(navController = navController, modifier = modifier)
            }

            composable(route = Screen.Login.route) {
                Log.d("navbar", "screen.login")
                ScreenLogin(navController = navController, modifier = modifier)
            }

            composable(route = Screen.Profile.route) {
                Log.d("navbar", "screen.profile")
                ScreenProfile(navController = navController, modifier = modifier)
            }

            composable(route = Screen.Page1.route) {
                Log.d("navbar", "screen.page1")
                ScreenPage1(navController = navController, modifier = modifier)
            }
        }
    }

}

sealed class Screen(val route: String) {
    object SignIn : Screen(route = "sign_in")
    object Login : Screen(route = "login")
    object Profile : Screen(route = "profile")
    object Page1 : Screen(route = "page1")
    object Page2 : Screen(route = "page2")
    object Favourite : Screen(route = "favourite")
    object Basket : Screen(route = "basket")

    object Notification : Screen(route = "notification")
}