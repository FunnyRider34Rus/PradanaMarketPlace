package com.elpablo.shop.ui.screens.page1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun Page1SearchInput(
    modifier: Modifier,
    placeholder: String,
    value: String,
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
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(12.dp)
                            .align(Alignment.CenterEnd),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
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