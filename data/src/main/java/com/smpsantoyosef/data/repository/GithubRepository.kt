package com.smpsantoyosef.data.repository

import com.smpsantoyosef.data.remote.datasource.GithubRemoteDataSource
import com.smpsantoyosef.domain.repository.IGithubRepository
import com.smpsantoyosef.domain.usecase.RepoUseCase
import com.smpsantoyosef.domain.utils.Result
import com.smpsantoyosef.entity.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 class GithubRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
): IGithubRepository {
    override suspend fun fetchRepo(params: RepoUseCase.Params): Flow<Result<List<Repo>>> {
        return githubRemoteDataSource.fetchRepo(params)
    }
}