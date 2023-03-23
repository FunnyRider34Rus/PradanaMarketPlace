package com.elpablo.shop.di

import com.elpablo.data.local.data_source.UserDatabase
import com.elpablo.data.local.repository.UserRepositoryImpl
import com.elpablo.data.remote.ShopApi
import com.elpablo.data.remote.repository.ContentRepositoryImpl
import com.elpablo.domain.repository.ContentRepository
import com.elpablo.domain.repository.UserRepository
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
    fun providesUserRepository(database: UserDatabase): UserRepository {
        return UserRepositoryImpl(database.userDao)
    }

    @Provides
    @Singleton
    fun providesContentRepository(api: ShopApi): ContentRepository {
        return ContentRepositoryImpl(api)
    }
}