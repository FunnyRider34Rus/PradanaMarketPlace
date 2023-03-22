package com.elpablo.shop.ui.screens.page1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.elpablo.shop.ui.screens.page1.Page1ViewState
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun Page1RowCategories(modifier: Modifier, viewState: Page1ViewState) {
    LazyRow(
        modifier = modifier,
        state = rememberLazyListState(),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        if (viewState.category != null) {
            items(count = viewState.category.size) { i ->
                Column(
                    modifier = Modifier
                        .width(48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(AppTheme.color.secondaryBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = viewState.category[i].icon),
                            contentDescription = null
                        )
                    }

                    Text(
                        text = viewState.category[i].label,
                        modifier = Modifier.padding(top = 11.dp),
                        color = AppTheme.color.page1CategoryTextColor,
                        style = AppTheme.typography.page1CategoryText
                    )
                }
            }
        }
    }
}