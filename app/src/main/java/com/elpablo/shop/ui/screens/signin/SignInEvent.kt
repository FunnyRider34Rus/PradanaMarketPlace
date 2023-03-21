package com.elpablo.shop.ui.screens.signin

interface SignInEvent {
    class EnteredFirstName(val enteredFirstName: String) : SignInEvent
    class EnteredLastName(val enteredLastName: String) : SignInEvent
    class EnteredEMail(val enteredEMail: String) : SignInEvent
    object CloseAlertDialog : SignInEvent
    object ClickSignIn : SignInEvent
    object ClickGoogleAuth : SignInEvent
    object ClickAppleAuth : SignInEvent
}