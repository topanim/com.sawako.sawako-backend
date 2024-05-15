package com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes


import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*


@Resource("/")
class FetchMembersByGuild(
    val parent: RGuilds.One,

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true
)