package com.elpablo.shop.domain.use_case

import com.elpablo.shop.domain.repository.UserRepository

class CheckIfUserAlreadyExistUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(firstName: String) = repository.isUserExisted(firstName = firstName)
}