package com.sawako.backend.data.guilds.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.guilds.Guilds
import org.jetbrains.exposed.sql.update

suspend fun Guilds.update(id: Long, settings: String): Unit = dbQuery {
    this.update(
        { Guilds.id eq id }
    ) {
        it[this.settings] = settings
    }
}