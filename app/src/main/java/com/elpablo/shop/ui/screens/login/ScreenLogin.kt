package com.elpablo.shop.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.elpablo.shop.R
import com.elpablo.shop.core.components.ShowAlertDialog
import com.elpablo.shop.navigation.Screen
import com.elpablo.shop.ui.screens.login.components.CustomPasswordTextField
import com.elpablo.shop.ui.screens.login.components.LoginCustomTextField
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenLogin(
    navController: NavController,
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val viewState by viewModel.viewState.collectAsState(LoginViewState())
    val focusManager = LocalFocusManager.current

    if (viewState.isError) {
        ShowAlertDialog(
            modifier = Modifier,
            title = "Error",
            text = viewState.errorMessage,
            onDismiss = { viewModel.onEvent(LoginEvent.CloseAlertDialog) }
        )
    }

    if (viewState.isValidEnteredData) {
        navController.navigate(route = Screen.Page1.route) {
            launchSingleTop = true
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 44.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.screen_login_title_text),
            color = AppTheme.color.primaryTextColor,
            style = AppTheme.typography.authTitleText
        )

        LoginCustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp),
            placeholder = stringResource(id = R.string.screen_login_input_first_name_hint),
            value = viewState.textFirstName,
            focusManager = focusManager,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredFirstName(it)) }
        )

        CustomPasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_login_input_password_hint),
            value = viewState.textPassword,
            onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) }
        )

        Button(
            onClick = { viewModel.onEvent(LoginEvent.ClickLogin) },
            modifier = Modifier
                .padding(top = 99.dp)
                .height(46.dp)
                .fillMaxWidth(),
            shape = AppTheme.shape.authButtonShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppTheme.color.buttonBackground,
                contentColor = AppTheme.color.textButtonColor
            )
        ) {
            Text(
                text = stringResource(id = R.string.screen_login_button_text),
                style = AppTheme.typography.authButtonText
            )
        }
    }
}

