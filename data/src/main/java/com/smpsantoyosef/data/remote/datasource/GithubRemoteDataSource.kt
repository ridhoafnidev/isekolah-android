package com.smpsantoyosef.data.remote.datasource

import com.smpsantoyosef.data.mapper.RepoMapper
import com.smpsantoyosef.data.remote.service.GithubService
import com.smpsantoyosef.data.utils.apiCall
import com.smpsantoyosef.data.utils.mapFromApiResponse
import com.smpsantoyosef.domain.usecase.RepoUseCase
import com.smpsantoyosef.domain.utils.Result
import com.smpsantoyosef.entity.Repo
import kotlinx.coroutines.flow.Flow

class GithubRemoteDataSource(
    private val githubService: GithubService,
    private val repoMapper: RepoMapper,
) {
    suspend fun fetchRepo(params: RepoUseCase.Params): Flow<Result<List<Repo>>> {
        return mapFromApiResponse(
            result = apiCall {
                githubService.fetchRepo(params.userName)
            }, repoMapper
        )
    }
}