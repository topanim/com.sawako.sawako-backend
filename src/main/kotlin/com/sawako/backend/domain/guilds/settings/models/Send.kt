package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class Send(
    val flag: Boolean = false,
    val autoDelete: AutoDelete = AutoDelete(),
    val text: SendText = SendText(),
    val embed: SendEmbed = SendEmbed()
)