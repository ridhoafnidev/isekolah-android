package com.smpsantoyosef.domain.repository

import com.smpsantoyosef.domain.usecase.AuthUseCase
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {
    suspend fun login(params: AuthUseCase.Params):Flow<Resource<User>>
}