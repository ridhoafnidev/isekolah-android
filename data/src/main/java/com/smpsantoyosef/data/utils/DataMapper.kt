package com.smpsantoyosef.data.utils

import com.smpsantoyosef.data.local.room.entity.UserEntity
import com.smpsantoyosef.entity.User

object DataMapper {
   fun User.toUserEntity() =
       UserEntity(
           profilePhotoUrl, roles, username, name, id, email
       )
    fun UserEntity.toUser() = User(
        profilePhotoUrl, roles, name, id, email
    )
}