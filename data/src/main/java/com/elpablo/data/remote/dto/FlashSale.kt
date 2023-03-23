package com.elpablo.data.remote.dto

import com.elpablo.domain.model.FlashSaleContent

data class FlashSale(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)

fun FlashSale.toFlashSaleContent() = FlashSaleContent(
    category = category,
    discount = discount,
    image_url = image_url,
    name = name,
    price = price
)