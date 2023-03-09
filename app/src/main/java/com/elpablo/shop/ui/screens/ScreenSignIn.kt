package com.elpablo.shop.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.shop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSignIn(modifier: Modifier) {

    var firstNameInput by rememberSaveable { mutableStateOf("") }
    var lastNameInput by rememberSaveable { mutableStateOf("") }
    var emailInput by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 44.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.screen_sign_in_title_text),
            color = MaterialTheme.colorScheme.surface,
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = firstNameInput,
            onValueChange = {
                firstNameInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.screen_sign_in_input_first_name_hint),
                    modifier = Modifier.fillMaxWidth(),
                    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                )
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true,
            shape = RoundedCornerShape(32.0.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.surface,
                containerColor = MaterialTheme.colorScheme.onBackground,
                placeholderColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
            )
        )

        OutlinedTextField(
            value = lastNameInput,
            onValueChange = {
                lastNameInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 35.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.screen_sign_in_input_last_name_hint),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true,
            shape = RoundedCornerShape(32.0.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.surface,
                containerColor = MaterialTheme.colorScheme.onBackground,
                placeholderColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
            )
        )

        OutlinedTextField(
            value = emailInput,
            onValueChange = {
                emailInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.screen_sign_in_input_email_hint),
                    modifier = Modifier.fillMaxWidth(),
                    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                )
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true,
            shape = RoundedCornerShape(32.0.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.surface,
                containerColor = MaterialTheme.colorScheme.onBackground,
                placeholderColor = MaterialTheme.colorScheme.tertiary,
                focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
            )
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 35.dp)
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.screen_sign_in_button_text),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.screen_sign_in_description_text),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable { /*TODO*/ },
                text = stringResource(id = R.string.screen_sign_in_description_button),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp)
                .clickable { /*TODO*/ },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = stringResource(id = R.string.screen_sign_in_button_with_google_text),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.surface
                )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                color = MaterialTheme.colorScheme.surface,
                text = stringResource(id = R.string.screen_sign_in_button_with_google_text),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp)
                .clickable { /*TODO*/ },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.apple_logo),
                contentDescription = stringResource(id = R.string.screen_sign_in_button_with_google_text),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.surface
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                color = MaterialTheme.colorScheme.surface,
                text = stringResource(id = R.string.screen_sign_in_button_with_apple_text),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun SignInPreview() {
    ScreenSignIn(Modifier)
}