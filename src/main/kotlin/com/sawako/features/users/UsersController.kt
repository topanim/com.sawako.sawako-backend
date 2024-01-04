package com.sawako.features.users

import com.sawako.database.users.UserDTO
import com.sawako.database.users.Users
import com.sawako.database.users.mapToUserDTO
import com.sawako.features.users.models.UserReceiveRemote

object UsersController {
    fun createUser(userReceiveRemote: UserReceiveRemote) {
        Users.insert(userReceiveRemote.mapToUserDTO())
    }

    fun getUsers(): List<UserDTO> = Users.fetchAll()

    fun getUser(id: Long): UserDTO = Users.fetchOne(id = id)
}