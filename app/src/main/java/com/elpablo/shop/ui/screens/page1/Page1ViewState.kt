package com.elpablo.shop.ui.screens.page1

import com.elpablo.shop.data.ProductCategory

data class Page1ViewState(
    val category: List<ProductCategory>? = null,
    val searchInput: String = "",
)