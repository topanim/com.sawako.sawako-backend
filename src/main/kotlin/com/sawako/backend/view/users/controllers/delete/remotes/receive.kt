package com.sawako.backend.view.users.controllers.delete.remotes

import com.sawako.backend.view.users.RUsers
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("")
class DeleteUser(
    val parent: RUsers.One
)

@Serializable
class DeleteUserReceive()