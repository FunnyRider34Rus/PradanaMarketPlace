package com.elpablo.shop.ui.screens.page1.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elpablo.shop.R
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun Page1AppBar(modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 15.dp),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append(stringResource(id = R.string.screen_page1_appbar_title_black_text) + " ")
                }
                withStyle(style = SpanStyle(color = AppTheme.color.buttonBackground)) {
                    append(stringResource(id = R.string.screen_page1_appbar_title_blue_text))
                }
            },
            style = AppTheme.typography.page1TitleText
        )
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = R.drawable.profile,
            contentDescription = stringResource(id = R.string.screen_profile_image_user_description),
            modifier = Modifier
                .padding(end = 47.dp)
                .size(30.dp)
                .clip(CircleShape)
        )
    }
}