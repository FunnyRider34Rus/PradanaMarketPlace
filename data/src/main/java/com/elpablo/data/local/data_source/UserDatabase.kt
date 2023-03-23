package com.elpablo.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elpablo.data.local.model.UserRoom

@Database(
    entities = [UserRoom::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val USERDATABASE_NAME = "users_db"
    }
}