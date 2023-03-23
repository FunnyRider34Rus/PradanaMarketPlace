package com.elpablo.shop.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ProfileMenuItem(modifier: Modifier, icon: Painter, text: String, button: @Composable () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(AppTheme.color.secondaryBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null
            )
        }
        Text(
            text = text,
            modifier = Modifier.padding(start = 6.dp),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.profileMenuItemText
        )
        Spacer(modifier = Modifier.weight(1f))
        button()
    }
}