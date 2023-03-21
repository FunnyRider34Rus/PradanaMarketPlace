package com.elpablo.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.elpablo.shop.ui.navigation.Screen
import com.elpablo.shop.ui.navigation.ShopNavHost
import com.elpablo.shop.ui.theme.ShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopTheme {
                ShopNavHost(
                    navController = rememberNavController(),
                    startDestination = Screen.SignIn.route
                )
            }
        }
    }
}