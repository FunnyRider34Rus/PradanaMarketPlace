package com.elpablo.shop.ui.screens.page1

import com.elpablo.core.utils.ProductCategory
import com.elpablo.domain.model.FlashSaleContent
import com.elpablo.domain.model.LatestContent

data class Page1ViewState(
    val category: List<ProductCategory>? = null,
    val latest: List<LatestContent>? = null,
    val sale: List<FlashSaleContent>? = null,
    val isLoading: Boolean = false,
    val isError: String? = null,
    val searchInput: String = "",
)