package com.elpablo.domain.repository

interface AuthRepository {
    suspend fun isUserAuthorized(): Boolean?
    suspend fun getCurrentUserID(): Int?
    suspend fun setAuthStatus(status: Boolean, currentUserID: Int)
}