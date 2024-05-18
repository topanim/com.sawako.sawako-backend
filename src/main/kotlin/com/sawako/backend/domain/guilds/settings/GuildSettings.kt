package com.sawako.backend.domain.guilds.settings

import com.sawako.backend.domain.guilds.settings.models.BaseSettings
import kotlinx.serialization.Serializable

@Serializable
data class GuildSettings(
    val autoMod: BaseSettings = BaseSettings()
)