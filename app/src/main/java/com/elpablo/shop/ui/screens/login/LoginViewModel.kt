package com.elpablo.shop.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.domain.use_case.CheckIfUserAlreadyExistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val isUserAlreadyExist: CheckIfUserAlreadyExistUseCase) :
    ViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredFirstName -> {
                _viewState.value = _viewState.value.copy(textFirstName = event.enteredFirstName)
            }

            is LoginEvent.EnteredPassword -> {
                _viewState.value = _viewState.value.copy(textPassword = event.enteredPassword)
            }

            is LoginEvent.ClickLogin -> {
                validateData()
            }

            is LoginEvent.CloseAlertDialog -> {
                _viewState.value = _viewState.value.copy(isError = false)
            }
        }
    }

    private fun validateData() {
        viewModelScope.launch {
            val isUserExist = isUserAlreadyExist.invoke(_viewState.value.textFirstName)
            if (!isUserExist) {
                _viewState.value = _viewState.value.copy(isError = true)
                _viewState.value =
                    _viewState.value.copy(errorMessage = "User with this FirstName not found. Please, SignUp.")
            } else {
                _viewState.value = _viewState.value.copy(isValidEnteredData = true)
            }
        }
    }
}