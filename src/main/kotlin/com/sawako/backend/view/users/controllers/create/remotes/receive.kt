package com.sawako.backend.view.users.controllers.create.remotes

import com.sawako.backend.view.users.RUsers
import io.ktor.resources.*
import kotlinx.serialization.Serializable


@Resource("")
class CreateUser(
    val parent: RUsers = RUsers()
)

@Serializable
class CreateUserReceive(
    val id: Long
)