package com.smpsantoyosef.data.mapper

import com.smpsantoyosef.apiresponse.BaseResponse
import com.smpsantoyosef.apiresponse.LoginApiResponse
import com.smpsantoyosef.data.utils.Mapper
import com.smpsantoyosef.entity.User
import javax.inject.Inject

class AuthMapper @Inject constructor(): Mapper<BaseResponse<LoginApiResponse>, User> {
    override fun mapFromApiResponse(type: BaseResponse<LoginApiResponse>): User {
        val data = type.data.user
        val token = type.data
        return User(
            data.profilePhotoUrl,
            data.roles,
            data.name,
            data.id,
            data.email,
            data.username,
            token.accessToken,
            token.tokenType
        )
    }

}