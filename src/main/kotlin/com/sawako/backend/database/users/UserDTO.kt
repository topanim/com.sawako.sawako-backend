package com.sawako.backend.database.users

import com.sawako.backend.database.users.Users.userId
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow

@Serializable
data class UserDTO(
    val id: Long
)

fun ResultRow.mapToUserDTO(): UserDTO = UserDTO(id = this[userId])
