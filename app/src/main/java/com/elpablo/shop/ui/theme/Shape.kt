package com.elpablo.shop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val authTextInputShape: Shape,
    val authButtonShape: Shape,
    val navBarShape: Shape,
    val page1LatestCardShape: Shape
)

val shapes = Shapes(
    authTextInputShape = RoundedCornerShape(15.dp),
    authButtonShape = RoundedCornerShape(15.dp),
    navBarShape = RoundedCornerShape(
        topStart = 30.dp,
        topEnd = 30.dp
    ),
    page1LatestCardShape = RoundedCornerShape(9.dp)
)