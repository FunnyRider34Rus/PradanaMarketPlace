package com.elpablo.shop.di

import android.app.Application
import androidx.room.Room
import com.elpablo.shop.data.data_source.UserDatabase
import com.elpablo.shop.data.repository.UserRepositoryImpl
import com.elpablo.shop.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            UserDatabase.USERDATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserRepository(database: UserDatabase): UserRepository {
        return UserRepositoryImpl(database.userDao)
    }
}