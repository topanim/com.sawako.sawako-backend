package com.sawako.backend.features.guilds

import com.sawako.backend.database.guilds.*
import com.sawako.backend.features.guilds.models.GuildReceiveRemote

object GuildsController {
    suspend fun createGuild(receiveRemote: GuildReceiveRemote) =
        GuildsDAO.insert(receiveRemote.id, "")

    suspend fun getGuild(receiveRemote: GuildReceiveRemote): GuildDTO =
        GuildsDAO.fetchOne(receiveRemote.id)

    suspend fun getGuilds(): List<GuildDTO> =
        GuildsDAO.fetchAll()

    suspend fun deleteGuild(receiveRemote: GuildReceiveRemote) =
        GuildsDAO.delete(receiveRemote.id)
}