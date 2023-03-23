package com.elpablo.shop.ui.screens.page1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
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
fun Page1SaleCard(
    modifier: Modifier,
    image: String,
    magazine: String,
    sale: Int,
    category: String,
    title: String,
    price: String
) {
    Box(
        modifier = modifier
            .height(221.dp)
            .width(174.dp)
            .clip(RoundedCornerShape(11.dp))
    ) {
        //Main background image
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        //Magazine image
        AsyncImage(
            model = magazine,
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .padding(7.dp)
                .align(Alignment.TopStart)
                .clip(CircleShape)
        )

        //Sale label
        Box(
            modifier = Modifier
                .padding(7.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0xFFF93A3A))
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$sale% off",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                style = AppTheme.typography.page1SaleLabelText
            )
        }

        Column(
            modifier = Modifier
                .width(96.dp)
                .align(Alignment.BottomStart)
                .padding(start = 9.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFC4C4C4)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = category,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                    style = AppTheme.typography.page1LatestHeaderText
                )
            }
            Text(
                text = title,
                modifier = Modifier.padding(top = 6.dp),
                color = Color.White,
                style = AppTheme.typography.page1SaleHeaderText
            )
            Text(
                text = "$$price",
                modifier = Modifier.padding(top = 6.dp, bottom = 12.dp),
                color = Color.White,
                style = AppTheme.typography.page1SaleLabelText
            )
        }

        //Button Add and Favourite
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape)
                    .background(
                        Color(0xFFC4C4C4)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(
                        Color(0xFFC4C4C4)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}