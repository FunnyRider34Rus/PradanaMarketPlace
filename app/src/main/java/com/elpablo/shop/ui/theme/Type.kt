package com.elpablo.shop.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.elpablo.shop.R

private val Montserrat = FontFamily(
    Font(resId = R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(resId = R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium)
)

private val Poppins = FontFamily(
    Font(resId = R.font.poppins_regular, weight = FontWeight.Normal),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium)
)
data class Typography(
    val authTitleText: TextStyle,
    val authButtonText: TextStyle,
    val authTextButtonText: TextStyle,
    val authHintText: TextStyle,
    val authLabelText: TextStyle,
    val profileTitleText: TextStyle,
    val profileHintText: TextStyle,
    val profileMenuItemText: TextStyle,
    val page1TitleText: TextStyle,
    val page1LocationText: TextStyle,
    val page1SearchHintText: TextStyle,
    val page1CategoryText: TextStyle,
    val page1LatestTitleText: TextStyle,
    val page1LatestOptionText: TextStyle
)

val typography = Typography(
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
    ),
    page1TitleText = TextStyle(
        fontSize = 20.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.3).sp
    ),
    page1LocationText = TextStyle(
        fontSize = 10.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.3).sp
    ),
    page1SearchHintText = TextStyle(
        fontSize = 9.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.3).sp
    ),
    page1CategoryText = TextStyle(
        fontSize = 8.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    page1LatestTitleText = TextStyle(
        fontSize = 15.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    ),
    page1LatestOptionText = TextStyle(
        fontSize = 9.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.3).sp
    )
)


