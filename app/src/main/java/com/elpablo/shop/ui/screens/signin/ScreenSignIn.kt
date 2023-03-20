package com.elpablo.shop.ui.screens.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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

        CustomTextField(
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

        CustomTextField(
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

        CustomTextField(
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

        TextButtonWithIcon(
            modifier = Modifier.padding(top = 70.dp),
            icon = painterResource(id = R.drawable.google_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_google_text),
            onClick = { viewModel.onEvent(SignInEvent.ClickGoogleAuth) }
        )

        TextButtonWithIcon(
            modifier = Modifier.padding(top = 38.dp),
            icon = painterResource(id = R.drawable.apple_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_apple_text),
            onClick = { viewModel.onEvent(SignInEvent.ClickAppleAuth) }
        )
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
            .fillMaxWidth()
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
fun TextButtonWithIcon(
    modifier: Modifier,
    icon: Painter,
    description: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = description,
            modifier = Modifier.size(23.dp),
            tint = AppTheme.color.primaryTextColor
        )
        Text(
            text = description,
            modifier = Modifier.padding(start = 12.dp),
            color = AppTheme.color.primaryTextColor,
            style = AppTheme.typography.authTextButtonText
        )
    }
}

@Preview
@Composable
fun SignInPreview() {
    ScreenSignIn(
        navController = rememberNavController(),
        modifier = Modifier
    )
}