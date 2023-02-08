package com.smpsantoyosef.data.remote.service

import com.smpsantoyosef.apiresponse.RepoApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    suspend fun fetchRepo(
        @Path("username")username:String
    ): Response<List<RepoApiResponse>>
}