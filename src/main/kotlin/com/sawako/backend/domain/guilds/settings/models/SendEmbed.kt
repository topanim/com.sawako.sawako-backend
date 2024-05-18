package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class SendEmbed(
    val flag: Boolean = false,
    val entity: DiscordEmbed = DiscordEmbed(),
)
