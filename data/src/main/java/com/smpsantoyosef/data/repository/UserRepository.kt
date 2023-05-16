package com.smpsantoyosef.data.repository

import com.smpsantoyosef.data.local.room.LocalDataSource
import com.smpsantoyosef.domain.repository.IUserRepository
import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val localDataSource: LocalDataSource
): IUserRepository {

    override suspend fun getUser(username: String, nisn: String): Flow<User> = localDataSource.getUser(username, nisn)

    override suspend fun storeUser(user: User): Flow<Boolean> = localDataSource.storeUser(user)

    override suspend fun storeId(id: Int) = localDataSource.storeId(id)

    override suspend fun storeToken(token: String) = localDataSource.storeToken(token)

    override suspend fun storeUsername(username: String) = localDataSource.storeUsername(username)

    override suspend fun logout() = localDataSource.logout()

    override suspend fun getIsLoggedIn(): Flow<Boolean> = localDataSource.isLoggedIn()

    override suspend fun getCurrentUsername(): Flow<String> = localDataSource.getCurrentUsername()

    override suspend fun getCurrentId(): Flow<Int> = localDataSource.getCurrentId()

    override suspend fun getCurrentToken(): Flow<String> = localDataSource.getCurrentToken()

}