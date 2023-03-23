package com.elpablo.shop.di

import com.elpablo.domain.repository.AuthRepository
import com.elpablo.domain.repository.UserRepository
import com.elpablo.domain.use_case.*
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

    @Provides
    @Singleton
    fun provideIfUserAlreadyExisted(repository: UserRepository): CheckIfUserAlreadyExistUseCase {
        return CheckIfUserAlreadyExistUseCase(repository)
    }
}