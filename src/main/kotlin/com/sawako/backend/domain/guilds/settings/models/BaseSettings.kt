package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
open class BaseSettings(
    val enabled: Boolean = false,
    val ignore: Ignore = Ignore(),
    val send: Send = Send(),
    val commands: List<Command> = emptyList()
)
