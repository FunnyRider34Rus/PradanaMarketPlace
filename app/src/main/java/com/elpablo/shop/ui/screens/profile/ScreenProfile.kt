package com.elpablo.shop.ui.screens.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.elpablo.shop.R
import com.elpablo.shop.navigation.Screen
import com.elpablo.shop.ui.screens.profile.components.ProfileMenuItem
import com.elpablo.shop.ui.screens.profile.components.ProfileTopAppBar
import com.elpablo.shop.ui.theme.AppTheme

@Composable
fun ScreenProfile(navController: NavController, modifier: Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        ProfileTopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.screen_profile_title_text),
            navigationAction = {
                IconButton(
                    onClick = { navController.navigate(Screen.Page1.route) }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.screen_profile_button_back_description),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 43.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = R.drawable.profile,
                contentDescription = stringResource(id = R.string.screen_profile_image_user_description),
                modifier = Modifier
                    .size(61.dp)
                    .clip(CircleShape)
            )

            Text(
                text = stringResource(id = R.string.screen_profile_button_change_user_photo_text),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .clickable { /* TODO */ },
                color = AppTheme.color.secondaryTextColor,
                style = AppTheme.typography.profileHintText
            )

            Text(
                text = "Satria Adhi Pradana",
                Modifier.padding(top = 17.dp),
                style = AppTheme.typography.profileTitleText
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp),
                shape = AppTheme.shape.authButtonShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppTheme.color.buttonBackground,
                    contentColor = AppTheme.color.textButtonColor
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.upload),
                        contentDescription = stringResource(id = R.string.screen_profile_button_upload_item_text),
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 42.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.screen_profile_button_upload_item_text),
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.authButtonText
                    )
                }
            }

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_trade_store_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_payment_method_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_balance_text),
                button = { Text(text = "$ 1593") }

            )

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.card),
                text = stringResource(id = R.string.screen_profile_menu_item_trade_history_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.restore),
                text = stringResource(id = R.string.screen_profile_menu_item_restore_purchase_text),
                button = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            )

            ProfileMenuItem(
                modifier = Modifier.padding(top = 14.dp),
                icon = painterResource(id = R.drawable.help),
                text = stringResource(id = R.string.screen_profile_menu_item_help_text),
                button = {

                }
            )

            ProfileMenuItem(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .clickable {
                        navController.navigate(Screen.SignIn.route) {
                            popUpTo(Screen.SignIn.route) {
                                inclusive = true
                            }
                        }
                    },
                icon = painterResource(id = R.drawable.logout),
                text = stringResource(id = R.string.screen_profile_menu_item_logout_text),
                button = {

                }
            )
        }
    }
}