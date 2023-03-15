package com.elpablo.shop.domain.use_case

import com.elpablo.shop.domain.model.User
import com.elpablo.shop.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetAllUsersUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> = repository.getAllUsers()
}