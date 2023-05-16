package com.smpsantoyosef.data.local.room

import com.smpsantoyosef.entity.User
import com.smpsantoyosef.data.local.datastore.MainDataStore
import com.smpsantoyosef.data.local.room.dao.UserDao
import com.smpsantoyosef.data.utils.DataMapper.toUser
import com.smpsantoyosef.data.utils.DataMapper.toUserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val userDao: UserDao,
    private val mainDataStore: MainDataStore
) {

    suspend fun isLoggedIn() = flow {
        mainDataStore.token.collect { emit(it.isNotEmpty()) }
    }.catch {
        Timber.e("LocalDataSource", "isLoggedIn: failed=${it.message}")
    }.flowOn(Dispatchers.IO)

    suspend fun logout() = mainDataStore.clear()

    suspend fun getCurrentUsername() = flow {
        mainDataStore.username.collect{ emit(it) }
    }.catch {
        Timber.e("LocalDataSource", "getCurrentUsername: failed=${it.message}")
    }.flowOn(Dispatchers.IO)

    suspend fun getCurrentToken() = flow {
        mainDataStore.token.collect{ emit(it) }
    }.catch {
        Timber.e("LocalDataSource", "getCurrentToken: failed=${it.message}")
    }.flowOn(Dispatchers.IO)

    suspend fun getCurrentId() = flow {
        mainDataStore.id.collect { emit(it) }
    }.catch {
        Timber.e("LocalDataSource", "getCurrentId: failed=${it.message}")
    }.flowOn(Dispatchers.IO)

    suspend fun storeUsername(username: String) = mainDataStore.storeData(MainDataStore.USERNAME, username)
    suspend fun storeNisn(nisn: String) = mainDataStore.storeData(MainDataStore.NISN, nisn)
    suspend fun storeToken(token: String) = mainDataStore.storeData(MainDataStore.TOKEN, token)
    suspend fun storeId(id: Int) = mainDataStore.storeData(MainDataStore.ID, id)

    suspend fun storeUser(user: User) = flow {
        userDao.storeUser(user.toUserEntity())
        emit(true)
    }.catch {
        Timber.e("LocalDataSource", "storeUser: failed=${it.message}")
        emit(false)
    }.flowOn(Dispatchers.IO)

    suspend fun getUser(email: String, nisn: String) = flow {
        userDao.getUserByUsernameNisn(email, nisn).collect { emit(it.toUser()) }
    }.catch {
        Timber.e("LocalDataSource", "getUser: failed=${it.message}")
    }.flowOn(Dispatchers.IO)

}