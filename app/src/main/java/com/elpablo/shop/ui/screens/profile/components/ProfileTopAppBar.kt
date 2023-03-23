package com.elpablo.shop.ui.screens.profile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.elpablo.shop.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar(modifier: Modifier, title: String, navigationAction: @Composable () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.profileTitleText
            )
        },
        modifier = modifier,
        navigationIcon = navigationAction
    )
}