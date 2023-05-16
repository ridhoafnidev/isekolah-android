package com.smpsantoyosef.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smpsantoyosef.data.local.room.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeUser(userEntity: UserEntity)

    @Query("SELECT * FROM user WHERE username = :username OR id = :nisn")
    fun getUserByUsernameNisn(username: String = "", nisn: String = ""): Flow<UserEntity>

}