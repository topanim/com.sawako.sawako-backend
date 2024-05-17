package com.sawako.backend.view.guilds.controllers.fetch.all.remotes

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("/")
class FetchGuilds(
    val parent: RGuilds = RGuilds(),

    // params
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true
)


@Serializable
class FetchGuildsReceive()

