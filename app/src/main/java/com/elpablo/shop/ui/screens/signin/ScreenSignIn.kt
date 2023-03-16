package com.elpablo.shop.ui.screens.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

    if (viewState.isValidEnteredData) {
        navController.navigate(route = Screen.Page1.route)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 44.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (viewState.isError) {
            ShowAlertDialog(
                modifier = Modifier,
                title = "Error",
                text = viewState.errorMessage,
                onDismiss = { viewModel.obtainEvent(SignInEvent.CloseAlertDialog) }
            )
        }


        Text(
            text = stringResource(id = R.string.screen_sign_in_title_text),
            color = AppTheme.color.primaryTextColor,
            style = AppTheme.typography.authTitleText
        )

        CustomTextField(
            modifier = Modifier.padding(top = 60.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_first_name_hint),
            value = viewState.textFirstName,
            onValueChange = {
                viewModel.obtainEvent(SignInEvent.EnteredFirstName(it))
            }
        )

        CustomTextField(
            modifier = Modifier.padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_last_name_hint),
            value = viewState.textLastName,
            onValueChange = {
                viewModel.obtainEvent(SignInEvent.EnteredLastName(it))
            }
        )

        CustomTextField(
            modifier = Modifier.padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_sign_in_input_email_hint),
            value = viewState.textEMail,
            onValueChange = {
                viewModel.obtainEvent(SignInEvent.EnteredEMail(it))
            }
        )

        Button(
            onClick = {
                viewModel.obtainEvent(SignInEvent.ClickSignIn)
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
                    .clickable { navController.navigate(route = Screen.Login.route) },
                text = stringResource(id = R.string.screen_sign_in_description_button),
                color = AppTheme.color.linkTextColor,
                style = AppTheme.typography.authLabelText
            )
        }

        TextButtonWithIcon(
            modifier = Modifier.padding(top = 70.dp),
            icon = painterResource(id = R.drawable.google_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_google_text),
            onClick = { /*TODO*/ }
        )

        TextButtonWithIcon(
            modifier = Modifier.padding(top = 38.dp),
            icon = painterResource(id = R.drawable.apple_logo),
            description = stringResource(id = R.string.screen_sign_in_button_with_apple_text),
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier,
    placeholder: String,
    value: String,
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
            .clickable { onClick },
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