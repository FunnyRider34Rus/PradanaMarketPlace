package com.elpablo.shop.domain.use_case

import com.elpablo.shop.domain.repository.AuthRepository

class GetUserAuthStatus(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() = repository.isUserAuthorized()
}