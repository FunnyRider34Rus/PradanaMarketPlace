package com.elpablo.shop.ui.screens.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EnteredFirstName -> {}
            is LoginEvent.EnteredPassword -> {}
            is LoginEvent.ClickLogin -> {}
            is LoginEvent.CloseAlertDialog -> {}
        }
    }
}