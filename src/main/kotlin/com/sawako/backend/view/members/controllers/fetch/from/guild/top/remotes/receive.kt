package com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes

import com.sawako.backend.view.members.RMembersByGuild
import io.ktor.resources.*

@Resource("top/")
class FetchMembersTopByGuild(
    val parent: RMembersByGuild,

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = false
)