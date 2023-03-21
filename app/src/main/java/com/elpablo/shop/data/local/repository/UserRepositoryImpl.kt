package com.elpablo.shop.data.local.repository

import com.elpablo.shop.data.local.data_source.UserDao
import com.elpablo.shop.domain.model.User
import com.elpablo.shop.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun getUser(firstName: String): User? {
        return userDao.getUser(firstName)
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun isUserExisted(firstName: String): Boolean {
        return userDao.existFirstName(firstName)
    }
}