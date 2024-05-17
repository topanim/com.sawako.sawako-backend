package com.sawako.backend.view.members.controllers.fetch.one.remotes

import com.sawako.backend.view.members.RMembers
import io.ktor.resources.*
import kotlinx.serialization.Serializable


@Resource("/")
class FetchMember(
    val parent: RMembers.One
)

@Serializable
class FetchMemberReceive()
