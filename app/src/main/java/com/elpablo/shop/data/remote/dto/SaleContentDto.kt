package com.elpablo.shop.data.remote.dto

data class SaleContentDto(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)