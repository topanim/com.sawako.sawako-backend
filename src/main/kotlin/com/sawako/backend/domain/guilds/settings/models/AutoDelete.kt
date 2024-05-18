package com.sawako.backend.domain.guilds.settings.models

import kotlinx.serialization.Serializable

@Serializable
data class AutoDelete(
    val flag: Boolean = false,
    val time: Int = 10
)