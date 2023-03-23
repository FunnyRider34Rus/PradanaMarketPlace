package com.elpablo.data.remote.dto

import com.elpablo.domain.model.LatestContent

data class Latest(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)

fun Latest.toLatestContent() = LatestContent(
    category = category,
    image_url = image_url,
    name = name,
    price = price
)