package com.elpablo.shop.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.elpablo.shop.R
import com.elpablo.shop.ui.theme.Montserrat

private val Montserrat = FontFamily(
    Font(resId = R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(resId = R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium)
)
data class Typographys(
    val authTitleText: TextStyle,
    val authButtonText: TextStyle,
    val authTextButtonText: TextStyle,
    val authHintText: TextStyle,
    val authLabelText: TextStyle,
    val profileTitleText: TextStyle,
    val profileHintText: TextStyle,
    val profileMenuItemText: TextStyle
)

val typography = Typographys(
    authTitleText = TextStyle(
        fontSize = 26.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = (-0.3).sp
    ),
    authButtonText = TextStyle(
        fontSize = 14.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.3).sp
    ),
    authTextButtonText = TextStyle(
        fontSize = 12.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    authHintText = TextStyle(
        fontSize = 11.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    authLabelText = TextStyle(
        fontSize = 10.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    profileTitleText = TextStyle(
        fontSize = 15.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.3).sp
    ),
    profileHintText = TextStyle(
        fontSize = 8.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    profileMenuItemText = TextStyle(
        fontSize = 14.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    )
)


