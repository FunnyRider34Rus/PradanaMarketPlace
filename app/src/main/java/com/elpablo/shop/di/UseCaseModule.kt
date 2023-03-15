package com.elpablo.shop.di

import com.elpablo.shop.domain.repository.AuthRepository
import com.elpablo.shop.domain.repository.UserRepository
import com.elpablo.shop.domain.use_case.GetAllUsersUseCase
import com.elpablo.shop.domain.use_case.GetUserAuthStatus
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
    fun providesGetUserAuthStatusUseCase(repository: AuthRepository): GetUserAuthStatus {
        return GetUserAuthStatus(repository)
    }

    @Provides
    @Singleton
    fun providesSetAuthStatusUseCase(repository: AuthRepository): SetAuthStatusUseCase {
        return SetAuthStatusUseCase(repository)
    }
}