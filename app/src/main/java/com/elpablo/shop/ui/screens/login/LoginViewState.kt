package com.elpablo.shop.ui.screens.login

data class LoginViewState(
    val textFirstName: String = "",
    val textPassword: String = "",
    val isValidEnteredData: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)