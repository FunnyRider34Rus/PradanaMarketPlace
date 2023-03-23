package com.elpablo.shop.ui.screens.signin

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.elpablo.shop.R
import com.elpablo.shop.core.components.ShowAlertDialog
import com.elpablo.shop.navigation.Screen
import com.elpablo.shop.ui.screens.signin.components.SignInCustomTextField
import com.elpablo.shop.ui.screens.signin.components.SignInTextButtonWithIcon
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenSignIn(
    navController: NavController,
    modifier: Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {

    val viewState by viewModel.viewState.collectAsState(SignInViewState())
    val focusManager = LocalFocusManager.current

    if (viewState.isError) {
        ShowAlertDialog(
            modifier = Modifier,
            title = "Error",
            text = viewState.errorMessage,
            onDismiss = { viewModel.onEvent(SignInEvent.CloseAlertDialog) }
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
            text = stringResource(id = R.string.screen_sign_in_title_text),
            color = AppTheme.color.primaryTextColor,
            style = AppTheme.typography.authTitleText
        )

        SignInCustomTextField(
            modifier = Modifier.padding(top = 60.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_first_name_hint),
            value = viewState.textFirstName,
            focusManager = focusManager,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onValueChange = {
                viewModel.onEvent(SignInEvent.EnteredFirstName(it))
            }
        )

        SignInCustomTextField(
            modifier = Modifier.padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_last_name_hint),
            value = viewState.textLastName,
            focusManager = focusManager,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onValueChange = {
                viewModel.onEvent(SignInEvent.EnteredLastName(it))
            }
        )

        SignInCustomTextField(
            modifier = Modifier.padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_email_hint),
            value = viewState.textEMail,
            focusManager = focusManager,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done,
            onValueChange = {
                viewModel.onEvent(SignInEvent.EnteredEMail(it))
            }
        )

        Button(
            onClick = {
                focusManager.clearFocus()
                viewModel.onEvent(SignInEvent.ClickSignIn)
            },
            modifier = Modifier
                .padding(top = 35.dp)
                .height(46.dp)
                .fillMaxWidth(),
            shape = AppTheme.shape.authButtonShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppTheme.color.buttonBackground,
                contentColor = AppTheme.color.textButtonColor
            )
        ) {
            Text(
                text = stringResource(id = R.string.screen_sign_in_button_text),
                style = AppTheme.typography.authButtonText
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.screen_sign_in_description_text),
                color = AppTheme.color.secondaryTextColor,
                style = AppTheme.typography.authLabelText
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        focusManager.clearFocus()
                        navController.navigate(route = Screen.Login.route)
                    },
                text = stringResource(id = R.string.screen_sign_in_description_button),
                color = AppTheme.color.linkTextColor,
                style = AppTheme.typography.authLabelText
            )
        }

        SignInTextButtonWithIcon(
            modifier = Modifier.padding(top = 70.dp),
            icon = painterResource(id = R.drawable.google_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_google_text),
            onClick = { viewModel.onEvent(SignInEvent.ClickGoogleAuth) }
        )

        SignInTextButtonWithIcon(
            modifier = Modifier.padding(top = 38.dp),
            icon = painterResource(id = R.drawable.apple_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_apple_text),
            onClick = { viewModel.onEvent(SignInEvent.ClickAppleAuth) }
        )
    }
}