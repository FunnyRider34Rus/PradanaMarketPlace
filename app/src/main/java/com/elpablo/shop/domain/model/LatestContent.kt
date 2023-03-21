package com.elpablo.shop.domain.model

import com.elpablo.shop.data.remote.dto.LatestContentDto

data class LatestContent(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)

fun LatestContentDto.toLatestContent(): LatestContent{
    return LatestContent(
        category = category,
        image_url = image_url,
        name = name,
        price = price
    )
}
