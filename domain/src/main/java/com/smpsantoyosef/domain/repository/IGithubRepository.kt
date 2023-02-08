package com.smpsantoyosef.domain.repository

import com.smpsantoyosef.domain.usecase.RepoUseCase
import com.smpsantoyosef.domain.utils.Result
import com.smpsantoyosef.entity.Repo
import kotlinx.coroutines.flow.Flow

interface IGithubRepository {
    suspend fun fetchRepo(params: RepoUseCase.Params):Flow<Result<List<Repo>>>
}