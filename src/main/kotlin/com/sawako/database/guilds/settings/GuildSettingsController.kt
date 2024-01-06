package com.sawako.database.guilds.settings

import java.io.File


object GuildSettingsController {
    private const val SETTINGS_PATTERN_PATH= "/settings/pattern.json"

    fun getDefaultSettings(): String = object {}.javaClass.getResource(SETTINGS_PATTERN_PATH)?.readText() ?: "{}"

    fun setNewDefault(settings: String) {
        val resourceUrl = object {}.javaClass.getResource(SETTINGS_PATTERN_PATH)
        resourceUrl?.let {
            File(
                it.toURI()
            ).writeText(settings)
        }
    }
}
