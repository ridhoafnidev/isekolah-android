package com.smpsantoyosef.domain.usecase

import com.smpsantoyosef.domain.repository.IGithubRepository
import com.smpsantoyosef.domain.utils.ApiUseCaseParams
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.domain.utils.Result
import com.smpsantoyosef.entity.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoUseCase @Inject constructor(
    private val repository: IGithubRepository
):ApiUseCaseParams<RepoUseCase.Params, List<Repo>>{

    override suspend fun execute(params: Params): Flow<Resource<List<Repo>>> {
        return repository.fetchRepo(params)
    }

    data class Params(val userName:String)
}