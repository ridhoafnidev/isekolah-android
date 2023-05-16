package com.smpsantoyosef.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smpsantoyosef.data.local.room.dao.UserDao
import com.smpsantoyosef.data.local.room.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class ISekolahDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}