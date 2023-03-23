package com.elpablo.domain.use_case

import com.elpablo.domain.model.User
import com.elpablo.domain.repository.UserRepository

class SaveUserToDatabaseUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.insertUser(user)
}