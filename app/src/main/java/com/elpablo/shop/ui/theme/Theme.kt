package com.elpablo.shop.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun ShopTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides lightPalette,
        LocalTypographyProvider provides typography,
        LocalShapeProvider provides shapes,
        content = content
    )
}

object AppTheme {
    val color: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColorProvider.current

    val typography: Typographys
    @Composable
    @ReadOnlyComposable
    get() = LocalTypographyProvider.current

    val shape: Shapes
    @Composable
    @ReadOnlyComposable
    get() = LocalShapeProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default colors provided")
}
val LocalTypographyProvider = staticCompositionLocalOf<Typographys> {
    error("No default typography provided")
}

val LocalShapeProvider = staticCompositionLocalOf<Shapes> {
    error("No default shapes provided")
}