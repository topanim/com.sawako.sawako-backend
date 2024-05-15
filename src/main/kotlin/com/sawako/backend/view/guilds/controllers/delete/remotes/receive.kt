package com.sawako.backend.view.guilds.controllers.delete.remotes

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("")
class DeleteGuild(
    val parent: RGuilds.One,
)

@Serializable
class DeleteGuildReceive()