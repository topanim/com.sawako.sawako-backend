package com.sawako.backend.database

import com.sawako.backend.database.guilds.Guilds
import com.sawako.backend.database.members.Members
import com.sawako.backend.database.store.Store
import com.sawako.backend.database.users.Users
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(){
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
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}