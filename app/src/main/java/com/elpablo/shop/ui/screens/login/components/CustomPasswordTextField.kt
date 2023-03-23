package com.elpablo.shop.ui.screens.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elpablo.shop.ui.theme.AppTheme

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