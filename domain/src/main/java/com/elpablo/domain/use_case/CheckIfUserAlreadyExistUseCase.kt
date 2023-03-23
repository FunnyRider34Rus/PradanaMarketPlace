package com.elpablo.domain.use_case

import com.elpablo.domain.repository.UserRepository

class CheckIfUserAlreadyExistUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(firstName: String) = repository.isUserExisted(firstName = firstName)
}