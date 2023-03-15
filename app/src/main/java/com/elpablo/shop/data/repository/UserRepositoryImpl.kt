package com.elpablo.shop.data.repository

import com.elpablo.shop.data.data_source.UserDao
import com.elpablo.shop.domain.model.User
import com.elpablo.shop.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun getUser(id: Int): User? {
        return userDao.getUser(id)
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}