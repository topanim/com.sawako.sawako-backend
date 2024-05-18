package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DiscordEmbedFooter(
    val text: String = "",
    @SerialName("icon_url") val iconUrl: String = ""
)