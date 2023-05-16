package com.smpsantoyosef.data.remote.datasource

import com.smpsantoyosef.data.mapper.AuthMapper
import com.smpsantoyosef.data.remote.service.AuthService
import com.smpsantoyosef.data.utils.apiCall
import com.smpsantoyosef.data.utils.mapFromApiResponse
import com.smpsantoyosef.domain.usecase.AuthUseCase
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRemoteDataSource @Inject constructor(
    private val authService: AuthService,
    private val authMapper: AuthMapper
) {
    suspend fun login(params: AuthUseCase.Params): Flow<Resource<User>> {
        return mapFromApiResponse(
            result = apiCall {
                authService.login(params.usernameNisn, params.password)
            }, authMapper
        )
    }
}