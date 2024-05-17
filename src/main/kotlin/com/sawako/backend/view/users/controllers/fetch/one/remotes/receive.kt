package com.sawako.backend.view.users.controllers.fetch.one.remotes

import com.sawako.backend.view.users.RUsers
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("/")
class FetchUser(
    val parent: RUsers.One
)

@Serializable
class FetchUserReceive()