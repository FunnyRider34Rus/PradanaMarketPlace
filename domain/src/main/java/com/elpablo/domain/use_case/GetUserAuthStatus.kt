package com.elpablo.domain.use_case

import com.elpablo.domain.repository.AuthRepository

class GetUserAuthStatus(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() = repository.isUserAuthorized()
}