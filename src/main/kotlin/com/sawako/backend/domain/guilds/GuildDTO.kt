package com.sawako.backend.domain.guilds

import com.sawako.backend.data.guilds.Guilds.id
import com.sawako.backend.data.guilds.Guilds.settings
import com.sawako.backend.domain.guilds.settings.GuildSettings
import com.sawako.backend.plugins.modules.json
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow


@Serializable
data class GuildDTO(
    val id: Long,
    val settings: GuildSettings
)

fun ResultRow.toGuildDTO(): GuildDTO {
    return GuildDTO(
        id = this[id],
        settings = json.decodeFromString<GuildSettings>(this[settings])
    )
}

fun List<ResultRow>.toListGuildDTO(): List<GuildDTO> {
    return map { it.toGuildDTO() }
}