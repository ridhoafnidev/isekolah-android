package com.smpsantoyosef.isekolah.di

import com.smpsantoyosef.data.module.ApiServiceModule
import com.smpsantoyosef.data.module.DatabaseModule
import com.smpsantoyosef.data.repository.AuthRepository
import com.smpsantoyosef.data.repository.UserRepository
import com.smpsantoyosef.domain.repository.IAuthRepository
import com.smpsantoyosef.domain.repository.IUserRepository
import com.smpsantoyosef.domain.usecase.UserInteractor
import com.smpsantoyosef.domain.usecase.UserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApiServiceModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(userRepoImpl: UserRepository): IUserRepository

    @Binds
    abstract fun bindAuthRepository(authRepoImpl: AuthRepository): IAuthRepository

    @Binds
    @Singleton
    abstract fun provideUserUseCase(userInteractor: UserInteractor): UserUseCase
}