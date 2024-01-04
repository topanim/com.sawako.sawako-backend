package com.sawako.database.guilds

import com.sawako.database.guilds.Guilds.guildId
import com.sawako.database.guilds.Guilds.settings
import com.sawako.database.guilds.settings.GuildSettingsController
import com.sawako.features.guilds.models.GuildReceiveRemote
import com.sawako.features.guilds.models.GuildResponseRemote
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

fun GuildReceiveRemote.mapTOGuildDTO(): GuildDTO {
    return GuildDTO(
        id = id,
        settings = GuildSettingsController.getDefaultSettings()
    )
}

fun GuildDTO.mapToGuildResponseRemote(): GuildResponseRemote {
    return GuildResponseRemote(
        id = id,
        settings = Json.parseToJsonElement(settings)
    )
}