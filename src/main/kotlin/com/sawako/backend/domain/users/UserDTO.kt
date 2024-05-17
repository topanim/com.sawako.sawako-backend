package com.sawako.backend.domain.users

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow
import com.sawako.backend.data.users.Users.id as userId

@Serializable
data class UserDTO(
    val id: Long
)

fun ResultRow.toUserDTO(): UserDTO = UserDTO(id = this[userId])

fun List<ResultRow>.toListUserDTO(): List<UserDTO> {
    return map { it.toUserDTO() }
}
