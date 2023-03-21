package com.elpablo.shop.domain.use_case

import com.elpablo.shop.core.utils.Response
import com.elpablo.shop.domain.model.LatestContent
import com.elpablo.shop.domain.model.toLatestContent
import com.elpablo.shop.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLatestContentUseCase @Inject constructor(
    private val repository: ContentRepository
) {
    operator fun invoke(): Flow<Response<List<LatestContent>>> = flow {
        try {
            emit(Response.Loading())
            val content = repository.getLatestContent().map { it.toLatestContent()}
            emit(Response.Success(content))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Response.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}