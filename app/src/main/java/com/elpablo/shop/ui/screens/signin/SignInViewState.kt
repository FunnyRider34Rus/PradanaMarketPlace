package com.elpablo.shop.ui.screens.signin

data class SignInViewState(
    val isFirstNameError: String = "",
    val isLastNameError: String = "",
    val isEMailError: String = "",
    val showGoogleAuth: Boolean = false,
    val showAppleAuth: Boolean = false
)