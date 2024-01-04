package com.sawako.database.users

import com.sawako.database.users.Users.userId
import com.sawako.features.users.models.UserReceiveRemote
import com.sawako.features.users.models.UserResponseRemote
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow

@Serializable
data class UserDTO(
    val id: Long
)

fun ResultRow.mapToUserDTO(): UserDTO = UserDTO(id = this[userId])

fun UserReceiveRemote.mapToUserDTO(): UserDTO = UserDTO(id = id)

fun UserDTO.mapToUserResponseRemote(): UserResponseRemote = UserResponseRemote(id = id)
