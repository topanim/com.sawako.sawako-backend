package com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*

@Resource("/top")
class FetchMembersTopByGuild(
    val parent: RGuilds.One,

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true
)