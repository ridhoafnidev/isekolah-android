package com.smpsantoyosef.data.repository

import com.smpsantoyosef.data.remote.datasource.AuthRemoteDataSource
import com.smpsantoyosef.domain.repository.IAuthRepository
import com.smpsantoyosef.domain.usecase.AuthUseCase
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
): IAuthRepository {
    override suspend fun login(params: AuthUseCase.Params): Flow<Resource<User>> =
        authRemoteDataSource.login(params)
}