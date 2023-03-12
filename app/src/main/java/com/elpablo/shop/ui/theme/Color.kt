package com.elpablo.shop.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val buttonBackground: Color,
    val textInputBackground: Color,
    val textButtonColor: Color,
    val labelBackground: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val linkTextColor: Color,
    val hintTextColor: Color,
    val page1CategoryTextColor: Color
)

val lightPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color(0xFFEEEFF4),
    buttonBackground = Color(0xFF4E55D7),
    textInputBackground = Color(0xFFE8E8E8),
    textButtonColor = Color(0xFFEAEAEA),
    labelBackground = Color(0xFFF93A3A),
    primaryTextColor = Color(0xFF040402),
    secondaryTextColor = Color(0xFF808080),
    linkTextColor = Color(0xFF254FE6),
    hintTextColor = Color(0xFF7B7B7B),
    page1CategoryTextColor = Color(0xFFA6A7AB)
)
