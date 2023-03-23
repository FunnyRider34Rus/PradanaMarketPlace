package com.elpablo.shop.ui.screens.page1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun Page1LatestCard(
    modifier: Modifier,
    image: String,
    category: String,
    title: String,
    price: String
) {
    Box(
        modifier = modifier
            .height(149.dp)
            .width(114.dp)
            .clip(RoundedCornerShape(9.dp))
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 7.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFC4C4C4)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = category,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                    style = AppTheme.typography.page1LatestCategoryText
                )
            }
            Text(
                text = title,
                modifier = Modifier.padding(top = 5.dp),
                color = Color.White,
                style = AppTheme.typography.page1LatestHeaderText
            )
            Text(
                text = "$$price",
                modifier = Modifier.padding(top = 2.dp, bottom = 9.dp),
                color = Color.White,
                style = AppTheme.typography.page1LatestPriceText
            )
        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.BottomEnd)
                .size(20.dp)
                .clip(CircleShape)
                .background(
                    Color(0xFFC4C4C4)
                )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.Center)
            )
        }
    }
}