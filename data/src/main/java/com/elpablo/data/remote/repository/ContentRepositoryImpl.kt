package com.elpablo.data.remote.repository

import com.elpablo.data.remote.ShopApi
import com.elpablo.data.remote.dto.toFlashSaleContent
import com.elpablo.data.remote.dto.toLatestContent
import com.elpablo.domain.model.FlashSaleContent
import com.elpablo.domain.model.LatestContent
import com.elpablo.domain.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val api: ShopApi) : ContentRepository {
    override suspend fun getLatestContent(): List<LatestContent> {
        return api.getLatestContent().latest.map { it.toLatestContent() }
    }

    override suspend fun getSaleContent(): List<FlashSaleContent> {
        return api.getSaleContent().flash_sale.map { it.toFlashSaleContent() }
    }
}