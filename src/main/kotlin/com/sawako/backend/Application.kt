package com.sawako.backend

import com.sawako.backend.database.DatabaseFactory
import com.sawako.backend.database.guilds.Guilds
import com.sawako.backend.database.members.Members
import com.sawako.backend.database.store.Store
import com.sawako.backend.database.users.Users
import com.sawako.backend.features.guilds.configureGuildsRouting
import com.sawako.backend.features.members.configureMembersRouting
import com.sawako.backend.features.users.configureUsersRouting
import com.sawako.backend.plugins.configureHTTP
import com.sawako.backend.plugins.configureRouting
import com.sawako.backend.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    configureRouting()

    // features
    configureUsersRouting()
    configureGuildsRouting()
    configureMembersRouting()
}
