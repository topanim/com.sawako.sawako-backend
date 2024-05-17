package com.sawako.backend.domain.users

import com.sawako.backend.data.users.Users
import com.sawako.backend.data.users.actions.create
import org.jetbrains.exposed.sql.Op

object UsersService {

    suspend fun createUser(id: Long) = Users.create(id)

    suspend fun getUser(id: Long) = Users.one(id).toUserDTO()

    suspend fun getUsers(page: Int, size: Int) = Users.all(
        size,
        (page.minus(1) * size).toLong()
    ) { Op.TRUE }.toListUserDTO()

    suspend fun deleteUser(id: Long) = Users.delete(id)
}