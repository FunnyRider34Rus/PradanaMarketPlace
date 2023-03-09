package com.elpablo.shop.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.shop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSignIn(modifier: Modifier) {

    var firstNameInput by remember { mutableStateOf(TextFieldValue("")) }
    var lastNameInput by remember { mutableStateOf(TextFieldValue("")) }
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .height(29.dp)
            .padding(horizontal = 44.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.screen_sign_in_title_text),
            color = MaterialTheme.colorScheme.surface,
            style = MaterialTheme.typography.titleLarge
        )

        BasicTextField(
            value = firstNameInput,
            onValueChange = {
                firstNameInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .clip(shape = MaterialTheme.shapes.extraLarge),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true
        ) { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = firstNameInput.toString(),
                visualTransformation = VisualTransformation.None,
                enabled = true,
                singleLine = true,
                interactionSource = MutableInteractionSource(),
                innerTextField = innerTextField,
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colorScheme.surface,
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    placeholderColor = MaterialTheme.colorScheme.tertiary,
                    focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
                )
            )

        }

        BasicTextField(
            value = lastNameInput,
            onValueChange = {
                lastNameInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .clip(shape = MaterialTheme.shapes.extraLarge),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true
        ) { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = lastNameInput.toString(),
                visualTransformation = VisualTransformation.None,
                enabled = true,
                singleLine = true,
                interactionSource = MutableInteractionSource(),
                innerTextField = innerTextField,
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colorScheme.surface,
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    placeholderColor = MaterialTheme.colorScheme.tertiary,
                    focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground
                )
            )

        }

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
                .fillMaxWidth()
                .padding(top = 35.dp)
        ) {
            Text(text = stringResource(id = R.string.screen_sign_in_button_text))
        }
    }
}

@Preview
@Composable
fun SignInPreview() {
    ScreenSignIn(Modifier)
}