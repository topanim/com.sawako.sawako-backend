package com.sawako.backend.database.guilds

import com.sawako.backend.database.guilds.Guilds.guildId
import com.sawako.backend.database.guilds.Guilds.settings
import kotlinx.serialization.Serializable
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