package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class SendText(
    val flag: Boolean = false,
    val content: String = ""
)