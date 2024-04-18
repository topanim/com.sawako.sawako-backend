package com.sawako.backend.features.users

import com.sawako.backend.database.users.UserDTO
import com.sawako.backend.database.users.UsersDAO
import com.sawako.backend.features.users.models.UserReceiveRemote

object UsersController {
    suspend fun createUser(userReceiveRemote: UserReceiveRemote) =
        UsersDAO.insert(userReceiveRemote.id)

    suspend fun getUsers(): List<UserDTO> = UsersDAO.fetchAll()

    suspend fun getUser(receiveRemote: UserReceiveRemote): UserDTO =
        UsersDAO.fetchOne(receiveRemote.id)

    suspend fun deleteUser(receiveRemote: UserReceiveRemote) =
        UsersDAO.delete(receiveRemote.id)
}