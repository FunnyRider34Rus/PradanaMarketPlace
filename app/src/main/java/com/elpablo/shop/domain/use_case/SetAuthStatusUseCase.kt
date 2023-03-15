package com.elpablo.shop.domain.use_case

import com.elpablo.shop.domain.repository.AuthRepository

class SetAuthStatusUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(status: Boolean, currentUserID: Int) = repository.setAuthStatus(status, currentUserID)
}