package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class DiscordEmbedAuthor(
    val name: String = "",
    val url: String = "",
    val iconUrl: String = "",
)