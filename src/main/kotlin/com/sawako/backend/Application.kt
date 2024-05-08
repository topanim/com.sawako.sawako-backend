package com.sawako.backend

import com.sawako.backend.data.DatabaseFactory
import com.sawako.backend.plugins.modules.configureRouting
import com.sawako.backend.plugins.plugins
import com.sawako.backend.view.routing
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()

    plugins()
    routing()
}
