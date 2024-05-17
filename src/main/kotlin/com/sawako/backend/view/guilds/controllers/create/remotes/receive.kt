package com.sawako.backend.view.guilds.controllers.create.remotes

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("")
class CreateGuild(
    val parent: RGuilds = RGuilds()
)

@Serializable
class CreateGuildReceive(
    val id: Long
)