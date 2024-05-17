package com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes


import com.sawako.backend.view.members.RMembersByGuild
import io.ktor.resources.*


@Resource("/")
class FetchMembersByGuild(
    val parent: RMembersByGuild,

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true
)