package com.sawako.backend.data.guilds.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.guilds.Guilds
import org.jetbrains.exposed.sql.insert

suspend fun Guilds.create(id: Long, guildSettings: String): Unit = dbQuery {
    this.insert {
        it[this.id] = id
        it[settings] = guildSettings
    }
}