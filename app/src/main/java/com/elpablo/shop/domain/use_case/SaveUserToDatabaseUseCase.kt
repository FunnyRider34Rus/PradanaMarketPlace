package com.elpablo.shop.domain.use_case

import com.elpablo.shop.domain.model.User
import com.elpablo.shop.domain.repository.UserRepository

class SaveUserToDatabaseUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.insertUser(user)
}