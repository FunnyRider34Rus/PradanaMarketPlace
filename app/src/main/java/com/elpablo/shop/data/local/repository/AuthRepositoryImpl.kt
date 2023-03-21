package com.elpablo.shop.data.local.repository

import android.app.Activity
import android.content.Context
import com.elpablo.shop.domain.repository.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context): AuthRepository {
    override suspend fun isUserAuthorized(): Boolean? {
        val sharedPref = (context as Activity?)?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getBoolean("auth", false)
    }

    override suspend fun getCurrentUserID(): Int? {
        val sharedPref = (context as Activity?)?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getInt("auth", -1)
    }

    override suspend fun setAuthStatus(status: Boolean, currentUserID: Int) {
        val sharedPref = (context as Activity?)?.getPreferences(Context.MODE_PRIVATE)
        sharedPref?.edit()?.putBoolean("auth", status)?.putInt("auth", currentUserID)?.apply()
    }
}