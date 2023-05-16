package com.smpsantoyosef.apiresponse

import com.google.gson.annotations.SerializedName

data class LoginApiResponse(
    @field:SerializedName("access_token")
    val accessToken: String,

    @field:SerializedName("token_type")
    val tokenType: String,

    @field:SerializedName("user")
    val user: UserApiResponse
)

data class UserApiResponse(

    @field:SerializedName("profile_photo_url")
    val profilePhotoUrl: String,

    @field:SerializedName("roles")
    val roles: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("username")
    val username: String
)
