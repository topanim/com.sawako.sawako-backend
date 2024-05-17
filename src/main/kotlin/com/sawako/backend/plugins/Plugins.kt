package com.sawako.backend.plugins

import com.sawako.backend.plugins.modules.configureRouting
import com.sawako.backend.plugins.modules.resources
import com.sawako.backend.plugins.modules.serialization
import io.ktor.server.application.*

fun Application.plugins() {
    serialization()
    resources()

    // TODO: debug
    configureRouting()
}
