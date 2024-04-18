package com.sawako.backend.database.guilds

import com.sawako.backend.database.guilds.Guilds.guildId
import com.sawako.backend.database.guilds.Guilds.settings
import com.sawako.backend.database.guilds.settings.GuildSettingsController
import com.sawako.backend.features.guilds.models.GuildReceiveRemote
import com.sawako.backend.features.guilds.models.GuildResponseRemote
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.ResultRow


@Serializable
data class GuildDTO(
    val id: Long,
    val settings: String
)

fun ResultRow.mapToGuildDTO(): GuildDTO {
    return GuildDTO(
        id = this[guildId],
        settings = this[settings]
    )
}