package com.elpablo.shop.data

import androidx.annotation.DrawableRes
import com.elpablo.shop.R

data class ProductCategory(
    val label: String,
    @DrawableRes val icon: Int
)

val categories = listOf(
    ProductCategory(
        label = "Phones",
        icon = R.drawable.ic_phones
    ),
    ProductCategory(
        label = "Headphones",
        icon = R.drawable.ic_headphones
    ),
    ProductCategory(
        label = "Games",
        icon = R.drawable.ic_games
    ),
    ProductCategory(
        label = "Cars",
        icon = R.drawable.ic_cars
    ),
    ProductCategory(
        label = "Furniture",
        icon = R.drawable.ic_furniture
    ),
    ProductCategory(
        label = "kids",
        icon = R.drawable.ic_kids
    )
)
