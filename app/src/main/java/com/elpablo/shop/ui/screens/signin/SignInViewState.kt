package com.elpablo.shop.ui.screens.signin

data class SignInViewState(
    val textFirstName: String = "",
    val textLastName: String = "",
    val textEMail: String = "",
    val isValidEnteredData: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val isLastNameError: String = "",
    val isEMailError: String = "",
    val showGoogleAuth: Boolean = false,
    val showAppleAuth: Boolean = false
)