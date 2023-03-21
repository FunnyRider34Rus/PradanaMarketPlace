package com.elpablo.shop.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elpablo.shop.R
import com.elpablo.shop.core.components.ShowAlertDialog
import com.elpablo.shop.ui.navigation.Screen
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

        CustomTextField(
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

@Composable
fun CustomTextField(
    modifier: Modifier,
    placeholder: String,
    value: String,
    focusManager: FocusManager,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .height(29.dp)
            .clip(AppTheme.shape.authTextInputShape)
            .background(AppTheme.color.textInputBackground),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            textStyle = AppTheme.typography.authHintText.copy(textAlign = TextAlign.Center),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            modifier = Modifier.fillMaxWidth(),
                            color = AppTheme.color.hintTextColor,
                            textAlign = TextAlign.Center,
                            style = AppTheme.typography.authHintText
                        )
                    }
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun CustomPasswordTextField(
    modifier: Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }

    val icon = if (passwordVisibility) {
        Icons.Default.Visibility
    } else {
        Icons.Default.VisibilityOff
    }

    Box(
        modifier = modifier
            .height(29.dp)
            .clip(AppTheme.shape.authTextInputShape)
            .background(AppTheme.color.textInputBackground),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            textStyle = AppTheme.typography.authHintText.copy(textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { passwordVisibility = !passwordVisibility },
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(12.dp)
                            .align(Alignment.CenterEnd),
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = AppTheme.color.hintTextColor
                        )
                    }
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            modifier = Modifier.fillMaxWidth(),
                            color = AppTheme.color.hintTextColor,
                            textAlign = TextAlign.Center,
                            style = AppTheme.typography.authHintText
                        )
                    }
                }
                innerTextField()
            }
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    ScreenLogin(
        navController = rememberNavController(),
        modifier = Modifier
    )
}