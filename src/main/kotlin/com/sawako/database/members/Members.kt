package com.sawako.database.members

import com.sawako.database.guilds.Guilds
import com.sawako.database.users.Users
import com.sawako.database.users.mapToUserDTO
import com.sawako.features.members.models.MemberReceiveRemote
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

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
    val upExp: Column<Int> = integer("up_exp").default(50)

    val wallet: Column<Int> = integer("wallet").default(0)

    override val primaryKey = PrimaryKey(memberId, name = "PK_Members_ID")

    init {
        uniqueIndex(guildId, userId)
    }

    fun insert(memberReceiveRemote: MemberReceiveRemote) {
        transaction {
            insert {
                it[guildId] = memberReceiveRemote.guildId
                it[userId] = memberReceiveRemote.userId
            }
        }
    }

    fun fetchOne(id: Long): MemberDTO {
        return transaction {
            select {
                memberId eq id
            }.single().mapToMemberDTO()
        }
    }

    fun fetchAll(): List<MemberDTO> {
        return transaction {
            selectAll().map {
                it.mapToMemberDTO()
            }
        }
    }

}