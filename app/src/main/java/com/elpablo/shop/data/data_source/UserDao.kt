package com.elpablo.shop.data.data_source

import androidx.room.*
import com.elpablo.shop.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUser(id: Int): User?

    @Upsert
    suspend fun insertUser(user: User)
}