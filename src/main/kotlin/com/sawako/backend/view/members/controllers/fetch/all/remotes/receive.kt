package com.sawako.backend.view.members.controllers.fetch.all.remotes

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("/")
class FetchMembers(
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = false
)


@Serializable
class FetchMembersReceive()