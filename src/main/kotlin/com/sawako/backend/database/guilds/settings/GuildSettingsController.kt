package com.sawako.backend.database.guilds.settings

import java.io.File


object GuildSettingsController {
    private const val SETTINGS_PATTERN_PATH = "/settings/testpattern.json"

    fun getDefaultSettings(): String {
        (object {}.javaClass.getResource(SETTINGS_PATTERN_PATH)?.readText() ?: "{}").let {
            println(it)
            return it
        }
    }

    fun setNewDefault(settings: String) {
        val resourceUrl = object {}.javaClass.getResource(SETTINGS_PATTERN_PATH)
        resourceUrl?.let {
            File(
                it.toURI()
            ).writeText(settings)
        }
    }
}
