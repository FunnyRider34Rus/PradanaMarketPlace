package com.elpablo.domain.use_case

import com.elpablo.domain.model.User
import com.elpablo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetAllUsersUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> = repository.getAllUsers()
}