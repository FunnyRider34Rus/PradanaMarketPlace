package com.elpablo.shop.domain.repository

import com.elpablo.shop.data.remote.dto.LatestContentDto
import com.elpablo.shop.data.remote.dto.SaleContentDto

interface ContentRepository {
    suspend fun getLatestContent(): List<LatestContentDto>
    suspend fun getSaleContent(): List<SaleContentDto>
}