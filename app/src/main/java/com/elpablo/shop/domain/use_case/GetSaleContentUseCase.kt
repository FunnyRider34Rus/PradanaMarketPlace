package com.elpablo.shop.domain.use_case

import com.elpablo.shop.core.utils.Response
import com.elpablo.shop.data.remote.dto.FlashSale
import com.elpablo.shop.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSaleContentUseCase @Inject constructor(
    private val repository: ContentRepository
) {
    operator fun invoke(): Flow<Response<List<FlashSale>>> = flow {
        try {
            emit(Response.Loading())
            val content = repository.getSaleContent()
            emit(Response.Success(content.flash_sale))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Response.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}