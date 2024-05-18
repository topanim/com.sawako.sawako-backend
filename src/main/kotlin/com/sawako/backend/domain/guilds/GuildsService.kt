package com.sawako.backend.domain.guilds

import com.sawako.backend.data.guilds.Guilds
import com.sawako.backend.data.guilds.actions.create
import com.sawako.backend.domain.guilds.settings.GuildSettings
import com.sawako.backend.domain.guilds.settings.GuildSettingsService
import com.sawako.backend.plugins.modules.json
import org.jetbrains.exposed.sql.Op

object GuildsService {
    suspend fun createGuild(id: Long) = Guilds.create(
        id,
        json.encodeToString(
            serializer = GuildSettings.serializer(),
            value = GuildSettingsService.defaultGuildSettings()
        )
    )

    suspend fun getGuild(id: Long): GuildDTO = Guilds.one(id).toGuildDTO()

    suspend fun getGuilds(
        page: Int,
        size: Int,
    ): List<GuildDTO> = Guilds.all(
        size,
        (page.minus(1) * size).toLong()
    ) { Op.TRUE }.toListGuildDTO()

    suspend fun getGuilds(guildIds: List<Long>): List<GuildDTO> =
        Guilds.many(guildIds).toListGuildDTO()

    suspend fun deleteGuild(id: Long) =
        Guilds.delete(id)
}
