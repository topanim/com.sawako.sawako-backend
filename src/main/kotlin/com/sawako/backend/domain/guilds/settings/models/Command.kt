package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class Command(
    val name: String,
    val description: String = "",
    val enabled: Boolean = true
)