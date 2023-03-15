package com.elpablo.shop.ui.screens.signin

interface SignInEvent {
    class InputFirstName(val firstName: String?) : SignInEvent
    class InputLastName(val lastName: String?) : SignInEvent
    class InputEMail(val eMail: String?) : SignInEvent
    object ClickLogIn : SignInEvent
    object ClickGoogleAuth : SignInEvent
    object ClickAppleAuth : SignInEvent
}