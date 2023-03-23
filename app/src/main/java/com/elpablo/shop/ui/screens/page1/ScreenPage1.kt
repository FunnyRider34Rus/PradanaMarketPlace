package com.elpablo.shop.ui.screens.page1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.elpablo.shop.R
import com.elpablo.shop.ui.screens.page1.components.*
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



