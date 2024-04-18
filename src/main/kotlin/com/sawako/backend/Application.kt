package com.sawako.backend

import com.sawako.backend.database.DatabaseFactory
import com.sawako.backend.features.guilds.configureGuildsRouting
import com.sawako.backend.features.members.configureMembersRouting
import com.sawako.backend.features.users.configureUsersRouting
import com.sawako.backend.plugins.configureRouting
import com.sawako.backend.plugins.configureSerialization
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

    // plugins
    configureSerialization()
    configureRouting()

    // features
    configureUsersRouting()
    configureGuildsRouting()
    configureMembersRouting()
}
