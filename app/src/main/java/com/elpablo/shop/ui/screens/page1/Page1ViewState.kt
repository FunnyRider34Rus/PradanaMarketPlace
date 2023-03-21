package com.elpablo.shop.ui.screens.page1

import com.elpablo.shop.data.ProductCategory
import com.elpablo.shop.data.remote.dto.FlashSale
import com.elpablo.shop.data.remote.dto.Latest

data class Page1ViewState(
    val category: List<ProductCategory>? = null,
    val latest: List<Latest>? = null,
    val sale: List<FlashSale>? = null,
    val isLoading: Boolean = false,
    val isError: String? = null,
    val searchInput: String = "",
)