package com.elpablo.shop.core.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShowAlertDialog(
    modifier: Modifier,
    title: String,
    text: String,
    onDismiss: () -> Unit
) {
        AlertDialog(
            onDismissRequest =  onDismiss,
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Ok")
                }
            },
            modifier = modifier,
            title = { Text(text = title) },
            text = { Text(text = text) }
        )
}