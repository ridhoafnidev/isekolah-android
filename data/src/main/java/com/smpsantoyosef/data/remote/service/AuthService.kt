package com.smpsantoyosef.data.remote.service

import com.smpsantoyosef.apiresponse.BaseResponse
import com.smpsantoyosef.apiresponse.LoginApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") password: String
    ): BaseResponse<LoginApiResponse>
}