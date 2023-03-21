package com.elpablo.shop.ui.screens.login

interface LoginEvent {
    class EnteredFirstName(val enteredFirstName: String) : LoginEvent
    class EnteredPassword(val enteredPassword: String) : LoginEvent
    object CloseAlertDialog : LoginEvent
    object ClickLogin : LoginEvent
}