package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
class Ignore(
    val permissions: List<Int> = emptyList(),
    val roles: List<Long> = emptyList(),
    val channels: List<Long> = emptyList(),
)