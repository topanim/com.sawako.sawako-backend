package com.sawako.backend.view.guilds

import io.ktor.resources.*

@Resource("/guilds")
class RGuilds {

    @Resource("{guildId}")
    class One(
        val parent: RGuilds = RGuilds(),

        // params
        val guildId: Long
    )
}