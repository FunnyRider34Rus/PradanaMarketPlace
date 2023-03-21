package com.elpablo.shop.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elpablo.shop.domain.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val USERDATABASE_NAME = "users_db"
    }
}