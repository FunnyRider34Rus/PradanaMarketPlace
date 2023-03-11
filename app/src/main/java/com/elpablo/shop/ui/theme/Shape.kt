package com.elpablo.shop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val authTextInputShape: Shape,
    val authButtonShape: Shape
)

val shapes = Shapes(
    authTextInputShape = RoundedCornerShape(15.dp),
    authButtonShape = RoundedCornerShape(15.dp)
)