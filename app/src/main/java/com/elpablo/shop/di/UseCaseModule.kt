package com.elpablo.shop.di

import com.elpablo.shop.domain.repository.AuthRepository
import com.elpablo.shop.domain.repository.UserRepository
import com.elpablo.shop.domain.use_case.GetAllUsersUseCase
import com.elpablo.shop.domain.use_case.GetUserAuthStatus
import com.elpablo.shop.domain.use_case.SaveUserToDatabaseUseCase
import com.elpablo.shop.domain.use_case.SetAuthStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllUsersUseCase(repository: UserRepository): GetAllUsersUseCase {
        return GetAllUsersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserAuthStatusUseCase(repository: AuthRepository): GetUserAuthStatus {
        return GetUserAuthStatus(repository)
    }

    @Provides
    @Singleton
    fun provideSetAuthStatusUseCase(repository: AuthRepository): SetAuthStatusUseCase {
        return SetAuthStatusUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSaveUserToDatabase(repository: UserRepository): SaveUserToDatabaseUseCase {
        return SaveUserToDatabaseUseCase(repository)
    }
}