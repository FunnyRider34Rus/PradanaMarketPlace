package com.elpablo.shop.domain.model

import com.elpablo.shop.data.remote.dto.SaleContentDto

data class SaleContent(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)

fun SaleContentDto.toSaleContent(): SaleContent {
    return SaleContent(
        category = category,
        discount = discount,
        image_url = image_url,
        name = name,
        price = price
    )
}
