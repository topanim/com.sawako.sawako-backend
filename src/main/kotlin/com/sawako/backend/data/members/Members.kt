package com.sawako.backend.data.members

import com.sawako.backend.data.BaseEntity
import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.guilds.Guilds
import com.sawako.backend.data.users.Users
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.insert

object Members : BaseEntity("members") {
    val guildId: Column<Long> = reference("guild_id", Guilds.id)
    val userId: Column<Long> = reference("user_id", Users.id)

    val name: Column<String> = varchar("name", 10).default("")
    val gender: Column<String> = varchar("gender", 7).default("")
    val birthdate: Column<String> = varchar("birthdate", 5).default("")
    val about: Column<String> = varchar("about", 40).default("")

    val lover: Column<Long?> = optReference("lover_id", id)

    val exp: Column<Int> = integer("exp").default(0)
    val lvl: Column<Int> = integer("lvl").default(0)
    val upExp: Column<Int> = integer("up_exp")

    val wallet: Column<Int> = integer("wallet").default(0)

    init {
        uniqueIndex(guildId, userId)
    }
}
