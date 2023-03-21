package com.elpablo.shop.ui.screens.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.shop.domain.model.User
import com.elpablo.shop.domain.use_case.CheckIfUserAlreadyExistUseCase
import com.elpablo.shop.domain.use_case.SaveUserToDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val isUserAlreadyExist: CheckIfUserAlreadyExistUseCase,
    private val saveUserToDatabaseUseCase: SaveUserToDatabaseUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignInViewState())
    val viewState: StateFlow<SignInViewState> = _viewState

    fun onEvent(event: SignInEvent) {
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
                validateData()
                saveUserToDatabase()
            }

            is SignInEvent.ClickGoogleAuth -> {
                _viewState.value = _viewState.value.copy(isError = true)
                _viewState.value = _viewState.value.copy(errorMessage = "SignIn with Google")
                _viewState.value = _viewState.value.copy(isValidEnteredData = true)
            }

            is SignInEvent.ClickAppleAuth -> {
                _viewState.value = _viewState.value.copy(isError = true)
                _viewState.value = _viewState.value.copy(errorMessage = "SignIn with Apple")
                _viewState.value = _viewState.value.copy(isValidEnteredData = true)
            }
        }
    }

    private fun validateData() {
        viewModelScope.launch {
            val validFirstName = _viewState.value.textFirstName.isNotBlank()
            val validSecondName = _viewState.value.textLastName.isNotBlank()
            val isUserExist = isUserAlreadyExist.invoke(_viewState.value.textFirstName)
            val validEMail =
                _viewState.value.textEMail.isNotBlank()
                        && _viewState.value.textEMail.contains("@")
                        && _viewState.value.textEMail.contains(".")
            if (isUserExist) {
                _viewState.value =
                    _viewState.value.copy(errorMessage = "User already exist. Please LogIn")
            }
            if (!validFirstName) _viewState.value =
                _viewState.value.copy(errorMessage = "Please, enter First Name")
            if (!validSecondName) _viewState.value =
                _viewState.value.copy(errorMessage = "Please, enter Last Name")
            if (!validEMail) _viewState.value =
                _viewState.value.copy(errorMessage = "Please, enter valid e-mail address")
            _viewState.value =
                _viewState.value.copy(isValidEnteredData = validFirstName && validSecondName && validEMail && !isUserExist)
            if (_viewState.value.isValidEnteredData) {
                _viewState.value = _viewState.value.copy(isError = false)
            } else {
                _viewState.value = _viewState.value.copy(isError = true)
            }
        }
    }

    private fun saveUserToDatabase() {
        if (_viewState.value.isValidEnteredData) {
            val user = User(
                firstName = _viewState.value.textFirstName,
                lastName = _viewState.value.textLastName,
                eMail = _viewState.value.textEMail,
                password = "",
                photo = ""
            )
            viewModelScope.launch {
                saveUserToDatabaseUseCase.invoke(user)
            }
        }
    }
}
