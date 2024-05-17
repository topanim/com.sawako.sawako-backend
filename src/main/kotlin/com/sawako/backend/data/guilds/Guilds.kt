package com.sawako.backend.data.guilds

import com.sawako.backend.data.BaseEntity
import org.jetbrains.exposed.sql.Column

object Guilds : BaseEntity("guilds") {
    val settings: Column<String> = text("settings")
}


