package com.smpsantoyosef.entity

data class User(
    val profilePhotoUrl: String = "",
    val roles: String = "",
    val name: String = "",
    val id: Int = 0,
    val email: String = "",
    val username: String = "",
    val token: String = "",
    val tokenType: String = ""
)
