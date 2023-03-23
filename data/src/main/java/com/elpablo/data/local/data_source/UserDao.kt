package com.elpablo.data.local.data_source

import androidx.room.*
import com.elpablo.data.local.model.UserRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<UserRoom>>

    @Query("SELECT * FROM user WHERE firstName = :firstName")
    suspend fun getUser(firstName: String): UserRoom?

    @Upsert
    suspend fun insertUser(user: UserRoom)

    @Query("SELECT EXISTS (SELECT * FROM user WHERE firstName = :firstName)")
    suspend fun existFirstName(firstName: String): Boolean
}