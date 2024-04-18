package com.sawako.backend.features.guilds.models

import com.sawako.database.guilds.GuildDTO
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

@Serializable
data class GuildResponseRemote(
    val id: Long,
    @Contextual val settings: JsonElement
)

fun GuildDTO.mapToGuildResponseRemote(): GuildResponseRemote {
    return GuildResponseRemote(
        id = id,
        settings = Json.parseToJsonElement(settings)
    )
}