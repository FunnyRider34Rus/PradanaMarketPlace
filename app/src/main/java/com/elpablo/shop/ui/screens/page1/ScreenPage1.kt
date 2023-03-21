package com.elpablo.shop.ui.screens.page1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.elpablo.shop.R
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenPage1(
    navController: NavController,
    modifier: Modifier,
    viewModel: Page1ViewModel = hiltViewModel()
) {

    val viewState by viewModel.viewState.collectAsState(Page1ViewState())

    Column(modifier = modifier.fillMaxSize()) {

        //Appbar
        Page1AppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 9.dp)
        )

        //Location Text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 37.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.screen_page1_location_text),
                style = AppTheme.typography.page1LocationText
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier.padding(start = 3.dp)
            )
        }

        //Search
        Page1SearchInput(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
                .padding(horizontal = 57.dp),
            placeholder = stringResource(id = R.string.screen_page1_search_hint_text),
            value = viewState.searchInput,
            onValueChange = { viewModel.onEvent(Page1Event.SearchInput(it)) }
        )

        //Categories
        Page1RowCategories(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 17.dp),
            viewState = viewState
        )

        if (viewState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            //Latest block header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 29.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.screen_page1_latest_title_text),
                    modifier = Modifier.padding(start = 11.dp),
                    style = AppTheme.typography.page1LatestTitleText
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.screen_page1_latest_option_text),
                    modifier = Modifier.padding(end = 11.dp),
                    color = AppTheme.color.secondaryTextColor,
                    style = AppTheme.typography.page1LatestOptionText
                )
            }


            LazyRow(
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 15.dp)
            ) {
                if (viewState.latest != null) {
                    items(count = viewState.latest!!.size) { i ->
                        Page1LatestCard(
                            modifier = Modifier.padding(horizontal = 11.dp),
                            image = viewState.latest!![i].image_url,
                            category = viewState.latest!![i].category,
                            title = viewState.latest!![i].name,
                            price = viewState.latest!![i].price.toString()
                        )
                    }
                }
            }

            //Sale block header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 29.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.screen_page1_sale_title_text),
                    modifier = Modifier.padding(start = 11.dp),
                    style = AppTheme.typography.page1LatestTitleText
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.screen_page1_sale_option_text),
                    modifier = Modifier.padding(end = 11.dp),
                    color = AppTheme.color.secondaryTextColor,
                    style = AppTheme.typography.page1LatestOptionText
                )
            }

            LazyRow(
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                contentPadding = PaddingValues(horizontal = 15.dp)
            ) {
                if (viewState.latest != null) {
                    items(count = viewState.sale!!.size) { i ->
                        Page1SaleCard(
                            modifier = Modifier.padding(11.dp),
                            image = viewState.sale!![i].image_url,
                            magazine = "",
                            sale = viewState.sale!![i].discount,
                            category = viewState.sale!![i].category,
                            title = viewState.sale!![i].name,
                            price = viewState.sale!![i].price.toString()
                        )
                    }
                }
            }
        }
    }
}

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