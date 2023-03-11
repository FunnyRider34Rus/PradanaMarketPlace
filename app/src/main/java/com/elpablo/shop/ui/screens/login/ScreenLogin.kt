package com.elpablo.shop.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elpablo.shop.R
import com.elpablo.shop.ui.navigation.Screen
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenLogin(navController: NavController, modifier: Modifier) {

    var firstNameInput by rememberSaveable { mutableStateOf("") }
    var passwordInput by rememberSaveable { mutableStateOf("") }

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
            modifier = modifier.padding(top = 72.dp),
            placeholder = stringResource(id = R.string.screen_login_input_first_name_hint),
            value = firstNameInput,
            onValueChange = { firstNameInput = it }
        )

        CustomTextField(
            modifier = modifier.padding(top = 35.dp),
            placeholder = stringResource(id = R.string.screen_login_input_password_hint),
            value = passwordInput,
            onValueChange = { passwordInput = it }
        )

        Button(
            onClick = { navController.navigate(Screen.Profile.route) },
            modifier = Modifier
                .padding(top = 99.dp)
                .height(46.dp)
                .fillMaxWidth(),
            shape = AppTheme.shape.authButtonShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppTheme.color.buttonBackground,
                contentColor = AppTheme.color.textButtonColor)
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

@Preview
@Composable
fun LoginPreview() {
    ScreenLogin(
        navController = rememberNavController(),
        modifier = Modifier
    )
}