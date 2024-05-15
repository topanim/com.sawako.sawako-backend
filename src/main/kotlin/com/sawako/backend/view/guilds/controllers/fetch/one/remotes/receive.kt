package com.sawako.backend.view.guilds.controllers.fetch.one.remotes

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*
import kotlinx.serialization.Serializable


@Resource("/")
class FetchGuild(
    val parent: RGuilds.One,
)


@Serializable
class FetchGuildReceive()
