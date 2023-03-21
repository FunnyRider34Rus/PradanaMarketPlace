package com.elpablo.shop.data.remote

import com.elpablo.shop.data.remote.dto.FlashSaleDto
import com.elpablo.shop.data.remote.dto.LatestDto
import retrofit2.http.GET

interface ShopApi {

    @GET("/v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestContent(): LatestDto

    @GET("/v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getSaleContent(): FlashSaleDto
}