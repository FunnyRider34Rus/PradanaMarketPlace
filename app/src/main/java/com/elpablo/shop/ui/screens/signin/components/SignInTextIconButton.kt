package com.elpablo.shop.ui.screens.signin.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun SignInTextButtonWithIcon(
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