package com.sawako.backend.view.users.controllers.fetch.all.remotes

import com.sawako.backend.view.users.RUsers
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("/")
class FetchUsers(
    val parent: RUsers = RUsers(),

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = false
)

@Serializable
class FetchUsersReceive()