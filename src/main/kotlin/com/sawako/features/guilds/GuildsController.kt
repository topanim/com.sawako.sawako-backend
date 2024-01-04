package com.sawako.features.guilds

import com.sawako.database.guilds.GuildDTO
import com.sawako.database.guilds.Guilds
import com.sawako.database.guilds.mapTOGuildDTO
import com.sawako.database.guilds.mapToGuildResponseRemote
import com.sawako.database.guilds.settings.GuildSettingsController
import com.sawako.features.guilds.models.GuildReceiveRemote
import com.sawako.features.guilds.models.GuildResponseRemote

object GuildsController {
    fun createGuild(guildReceiveRemote: GuildReceiveRemote) {
        Guilds.insert(
            guildReceiveRemote.mapTOGuildDTO()
        )
    }

    fun getGuild(id: Long): GuildDTO = Guilds.fetchOne(id = id)

    fun getGuilds(): List<GuildResponseRemote> = Guilds.fetchAll().map { it.mapToGuildResponseRemote() }

}