package com.elpablo.domain.use_case

import com.elpablo.domain.repository.AuthRepository

class SetAuthStatusUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(status: Boolean, currentUserID: Int) =
        repository.setAuthStatus(status, currentUserID)
}