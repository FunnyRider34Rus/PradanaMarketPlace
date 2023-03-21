package com.elpablo.shop.data.local.data_source

import androidx.room.*
import com.elpablo.shop.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE firstName = :firstName")
    suspend fun getUser(firstName: String): User?

    @Upsert
    suspend fun insertUser(user: User)

    @Query("SELECT EXISTS (SELECT * FROM user WHERE firstName = :firstName)")
    suspend fun existFirstName(firstName: String): Boolean
}