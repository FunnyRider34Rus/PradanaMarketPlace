package com.elpablo.shop.domain.repository

import com.elpablo.shop.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun getUser(firstName: String): User?
    suspend fun insertUser(user: User)
    suspend fun isUserExisted(firstName: String): Boolean
}