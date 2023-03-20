package com.elpablo.shop.ui.navigation

import androidx.annotation.DrawableRes
import com.elpablo.shop.R

sealed class BottomBarItems(
    val route: String,
    @DrawableRes val icon:  Int
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