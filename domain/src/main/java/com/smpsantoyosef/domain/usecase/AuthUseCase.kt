package com.smpsantoyosef.domain.usecase

import com.smpsantoyosef.domain.repository.IAuthRepository
import com.smpsantoyosef.domain.utils.ApiUseCaseParams
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: IAuthRepository
): ApiUseCaseParams<AuthUseCase.Params, User> {

    override suspend fun execute(params: Params): Flow<Resource<User>> = repository.login(params)

    data class Params(val usernameNisn: String, val password: String)

}

