package com.sawako.backend.plugins.modules

import kotlinx.serialization.json.Json

val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    encodeDefaults = true
}