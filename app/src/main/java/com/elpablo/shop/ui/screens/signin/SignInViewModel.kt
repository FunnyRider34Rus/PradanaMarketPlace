package com.elpablo.shop.ui.screens.signin

import androidx.lifecycle.ViewModel
import com.elpablo.shop.domain.use_case.GetAllUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAuthStatus: GetAllUsersUseCase,
    private val getAllUsers: GetAllUsersUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignInViewState())
    val viewState: StateFlow<SignInViewState> = _viewState

    fun obtainEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.EnteredEMail -> {
                _viewState.value = _viewState.value.copy(textEMail = event.enteredEMail)
            }

            is SignInEvent.EnteredLastName -> {
                _viewState.value = _viewState.value.copy(textLastName = event.enteredLastName)
            }

            is SignInEvent.EnteredFirstName -> {
                _viewState.value = _viewState.value.copy(textFirstName = event.enteredFirstName)
            }

            is SignInEvent.CloseAlertDialog -> {
                _viewState.value = _viewState.value.copy(isError = false)
            }

            is SignInEvent.ClickSignIn -> {
                _viewState.value = _viewState.value.copy(isError = !validateData())
                _viewState.value = _viewState.value.copy(isValidEnteredData = validateData())
                saveUserToDatabase()
            }

            is SignInEvent.ClickGoogleAuth -> {}
            is SignInEvent.ClickAppleAuth -> {}
        }
    }

    private fun validateData(): Boolean {
        val validFirstName = _viewState.value.textFirstName.isNotBlank()
        val validSecondName = _viewState.value.textLastName.isNotBlank()
        val validEMail =
            _viewState.value.textEMail.isNotBlank() && _viewState.value.textEMail.contains("@") && _viewState.value.textEMail.contains(
                "."
            )
        if (!validFirstName) _viewState.value =
            _viewState.value.copy(errorMessage = "Please, enter First Name")
        if (!validSecondName) _viewState.value =
            _viewState.value.copy(errorMessage = "Please, enter Last Name")
        if (!validEMail) _viewState.value =
            _viewState.value.copy(errorMessage = "Please, enter valid e-mail address")
        return validFirstName && validSecondName && validEMail
    }

    private fun saveUserToDatabase() {
        if (validateData()) {
            //TODO("Сохранение пользователя в базу")
        }
    }
}