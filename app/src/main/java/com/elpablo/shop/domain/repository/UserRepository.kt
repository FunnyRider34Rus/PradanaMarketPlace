package com.elpablo.shop.domain.repository

import com.elpablo.shop.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun getUser(id: Int): User?
    suspend fun insertUser(user: User)
}