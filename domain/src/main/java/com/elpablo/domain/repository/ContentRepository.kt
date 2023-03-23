package com.elpablo.domain.repository

import com.elpablo.domain.model.FlashSaleContent
import com.elpablo.domain.model.LatestContent

interface ContentRepository {
    suspend fun getLatestContent(): List<LatestContent>
    suspend fun getSaleContent(): List<FlashSaleContent>
}