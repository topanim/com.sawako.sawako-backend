package com.sawako.features.guilds.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class GuildResponseRemote(
    val id: Long,
    @Contextual val settings: JsonElement
)