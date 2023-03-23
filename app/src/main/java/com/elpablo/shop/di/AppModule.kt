package com.elpablo.shop.di

import android.app.Application
import androidx.room.Room
import com.elpablo.core.utils.Const
import com.elpablo.data.local.data_source.UserDatabase
import com.elpablo.data.remote.ShopApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideShopApi(): ShopApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShopApi::class.java)
    }
}