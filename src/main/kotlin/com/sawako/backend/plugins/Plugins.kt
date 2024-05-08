package com.sawako.backend.plugins

import com.sawako.backend.plugins.modules.configureRouting
import com.sawako.backend.plugins.modules.serialization
import com.sawako.backend.view.routing
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun Application.plugins() {
    serialization()

    // TODO: debug
    configureRouting()
}