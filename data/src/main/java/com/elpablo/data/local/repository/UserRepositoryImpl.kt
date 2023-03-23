package com.elpablo.data.local.repository

import com.elpablo.data.local.data_source.UserDao
import com.elpablo.data.local.model.toUser
import com.elpablo.data.local.model.toUserRoom
import com.elpablo.domain.model.User
import com.elpablo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl (
    private val userDao: UserDao
) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers().map { list -> list.map { item -> item.toUser() } }
    }

    override suspend fun getUser(firstName: String): User? {
        return userDao.getUser(firstName)?.toUser()
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toUserRoom())
    }

    override suspend fun isUserExisted(firstName: String): Boolean {
        return userDao.existFirstName(firstName)
    }
}