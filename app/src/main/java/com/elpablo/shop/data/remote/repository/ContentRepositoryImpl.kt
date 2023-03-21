package com.elpablo.shop.data.remote.repository

import com.elpablo.shop.data.remote.ShopApi
import com.elpablo.shop.data.remote.dto.LatestContentDto
import com.elpablo.shop.data.remote.dto.SaleContentDto
import com.elpablo.shop.domain.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val api: ShopApi): ContentRepository {
    override suspend fun getLatestContent(): List<LatestContentDto> {
        return api.getLatestContent()
    }

    override suspend fun getSaleContent(): List<SaleContentDto> {
        return api.getSaleContent()
    }
}