package com.smpsantoyosef.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.smpsantoyosef.entity.User

@Entity(
    tableName = "user"
)
data class UserEntity(
    @ColumnInfo(name = "profile_photo_url")
    val profilePhotoUrl: String,

    @ColumnInfo(name = "roles")
    val roles: String,

    @ColumnInfo(name = "username")
    @PrimaryKey
    val username: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "email")
    val email: String
)

fun UserEntity.toUser() = User(
    this.profilePhotoUrl,
    this.roles,
    this.name,
    this.id,
    this.email,
    this.username,
)