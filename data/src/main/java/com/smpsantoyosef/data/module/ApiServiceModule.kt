package com.smpsantoyosef.data.module

import com.smpsantoyosef.data.remote.service.GithubService
import com.smpsantoyosef.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Provides
    @Singleton
    fun provideApiService(@AppBaseUrl retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}