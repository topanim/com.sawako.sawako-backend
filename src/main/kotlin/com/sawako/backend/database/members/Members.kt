package com.sawako.backend.database.members

import com.sawako.backend.database.guilds.Guilds
import com.sawako.backend.database.users.Users
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Members : Table("members") {
    val memberId: Column<Long> = long("member_id").autoIncrement()
    val guildId: Column<Long> = reference("guild_id", Guilds.guildId)
    val userId: Column<Long> = reference("user_id", Users.userId)

    val name: Column<String> = varchar("name", 10).default("")
    val gender: Column<String> = varchar("gender", 7).default("")
    val birthdate: Column<String> = varchar("birthdate", 5).default("")
    val about: Column<String> = varchar("about", 40).default("")

    val lover: Column<Long?> = optReference("lover_id", memberId)

    val exp: Column<Int> = integer("exp").default(0)
    val lvl: Column<Int> = integer("lvl").default(0)
    val upExp: Column<Int> = integer("up_exp")

    val wallet: Column<Int> = integer("wallet").default(0)

    override val primaryKey = PrimaryKey(memberId, name = "PK_Members_ID")

    const val A = 10
    const val B: Double = 1.3

    init {
        uniqueIndex(guildId, userId)
    }

}