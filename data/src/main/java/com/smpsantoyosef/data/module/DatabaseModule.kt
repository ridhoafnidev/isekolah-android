package com.smpsantoyosef.data.module

import android.content.Context
import androidx.room.Room
import com.smpsantoyosef.data.local.room.ISekolahDatabase
import com.smpsantoyosef.data.local.room.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ISekolahDatabase = Room.databaseBuilder(
        context,
        ISekolahDatabase::class.java, "ISekolah.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideUserDao(database: ISekolahDatabase):UserDao = database.userDao()

}