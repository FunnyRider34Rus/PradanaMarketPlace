package com.elpablo.shop.domain.repository

import com.elpablo.shop.data.remote.dto.FlashSaleDto
import com.elpablo.shop.data.remote.dto.LatestDto

interface ContentRepository {
    suspend fun getLatestContent(): LatestDto
    suspend fun getSaleContent(): FlashSaleDto
}