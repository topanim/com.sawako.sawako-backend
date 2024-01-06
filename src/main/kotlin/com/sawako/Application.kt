package com.sawako

import com.sawako.database.guilds.Guilds
import com.sawako.database.members.Members
import com.sawako.database.store.Store
import com.sawako.database.users.Users
import com.sawako.features.guilds.configureGuildsRouting
import com.sawako.features.members.configureMembersRouting
import com.sawako.features.users.configureUsersRouting
import com.sawako.plugins.configureHTTP
import com.sawako.plugins.configureRouting
import com.sawako.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:3001/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "12356"
    )

    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(
            Guilds,
            Users,
            Members,
            Store
        )

        SchemaUtils.createMissingTablesAndColumns(
            Guilds,
            Users,
            Members,
            Store
        )
    }


    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
//    configureDatabases()
    configureRouting()

    //  features
    configureUsersRouting()
    configureGuildsRouting()
    configureMembersRouting()

    // openapi
    configureHTTP()

}
