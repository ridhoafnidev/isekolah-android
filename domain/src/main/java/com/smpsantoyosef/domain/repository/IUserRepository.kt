package com.smpsantoyosef.domain.repository

import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    suspend fun getUser(username: String = "", nisn: String = ""): Flow<User>
    suspend fun storeUser(user: User): Flow<Boolean>
    suspend fun storeId(id: Int)
    suspend fun storeToken(token: String)
    suspend fun storeUsername(username: String)
    suspend fun logout()
    suspend fun getIsLoggedIn(): Flow<Boolean>
    suspend fun getCurrentUsername(): Flow<String>
    suspend fun getCurrentId(): Flow<Int>
    suspend fun getCurrentToken(): Flow<String>
}