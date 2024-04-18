package com.sawako.backend.database.guilds

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Guilds : Table("guilds") {
    val guildId: Column<Long> = long("id")
    val settings: Column<String> = text("settings")

    override val primaryKey = PrimaryKey(guildId, name = "PK_Guilds_ID")
}