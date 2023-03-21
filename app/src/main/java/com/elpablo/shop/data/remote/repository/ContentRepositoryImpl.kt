package com.elpablo.shop.data.remote.repository

import com.elpablo.shop.data.remote.ShopApi
import com.elpablo.shop.data.remote.dto.FlashSaleDto
import com.elpablo.shop.data.remote.dto.LatestDto
import com.elpablo.shop.domain.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val api: ShopApi) : ContentRepository {
    override suspend fun getLatestContent(): LatestDto {
        return api.getLatestContent()
    }

    override suspend fun getSaleContent(): FlashSaleDto {
        return api.getSaleContent()
    }
}