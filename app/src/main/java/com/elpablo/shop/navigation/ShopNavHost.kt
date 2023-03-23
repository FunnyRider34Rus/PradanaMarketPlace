package com.elpablo.shop.navigation

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elpablo.shop.R
import com.elpablo.shop.core.components.BottomBar
import com.elpablo.shop.ui.screens.login.ScreenLogin
import com.elpablo.shop.ui.screens.page1.ScreenPage1
import com.elpablo.shop.ui.screens.profile.ScreenProfile
import com.elpablo.shop.ui.screens.signin.ScreenSignIn

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

sealed class BottomBarItems(
    val route: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomBarItems(
        route = Screen.Page1.route,
        icon = R.drawable.ic_home
    )

    object Favourite : BottomBarItems(
        route = Screen.Favourite.route,
        icon = R.drawable.ic_favourite
    )

    object Basket : BottomBarItems(
        route = Screen.Basket.route,
        icon = R.drawable.ic_basket
    )

    object Notification : BottomBarItems(
        route = Screen.Notification.route,
        icon = R.drawable.ic_notification
    )

    object Profile : BottomBarItems(
        route = Screen.Profile.route,
        icon = R.drawable.ic_profile
    )
}