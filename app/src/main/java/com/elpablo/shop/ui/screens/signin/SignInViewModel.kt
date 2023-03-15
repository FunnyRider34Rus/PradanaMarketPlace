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
            is SignInEvent.InputFirstName -> {}
            is SignInEvent.InputLastName -> {}
            is SignInEvent.InputEMail -> {}
            is SignInEvent.ClickLogIn -> {}
            is SignInEvent.ClickGoogleAuth -> {}
            is SignInEvent.ClickAppleAuth -> {}
        }
    }
}