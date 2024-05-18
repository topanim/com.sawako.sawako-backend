package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class DiscordEmbedField(
    val name: String = "",
    val value: String = "",
    val inline: Boolean = false,
)