package com.sawako.database.members

import com.sawako.database.guilds.Guilds
import com.sawako.database.users.Users
import com.sawako.features.members.models.MemberReceiveRemote
import com.sawako.features.members.models.UpdateMemberBioReceiveRemote
import com.sawako.features.members.models.UpdateMemberWalletReceiveRemote
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.plus
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

    fun insert(receiveRemote: MemberReceiveRemote) {
        transaction {
            insert {
                it[guildId] = receiveRemote.guildId
                it[userId] = receiveRemote.userId
            }
        }
    }

    fun updateWallet(receiveRemote: UpdateMemberWalletReceiveRemote) {
        transaction {
            update({
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
            }) {
                it[wallet] = wallet + receiveRemote.amount
            }
        }
    }

    fun updateBio(receiveRemote: UpdateMemberBioReceiveRemote): MemberDTO {
        return transaction {
            update({
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
            }) {
                receiveRemote.name?.let { value -> it[name] = value }
                receiveRemote.birthdate?.let { value -> it[birthdate] = value }
                receiveRemote.gender?.let { value -> it[gender] = value }
                receiveRemote.about?.let { value -> it[about] = value }
            }

            select {
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
            }.single().mapToMemberDTO()
        }
    }

    fun resetBio(receiveRemote: MemberReceiveRemote): MemberDTO {
        return transaction {
            update({
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
            }) {
                it[name] = ""
                it[birthdate] = ""
                it[gender] = ""
                it[about] = ""
            }

            select {
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
            }.single().mapToMemberDTO()
        }
    }

    fun fetchOne(id: Long): MemberDTO {
        return transaction {
            select {
                memberId eq id
            }.single().mapToMemberDTO()
        }
    }

    fun fetchOne(receiveRemote: MemberReceiveRemote): MemberDTO {
        return transaction {
            select {
                (guildId eq receiveRemote.guildId) and
                        (userId eq receiveRemote.userId)
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

    fun fetchGuildTop(id: Long): List<MemberDTO> {
        return transaction {
            select { guildId eq id}
                .orderBy(lvl to SortOrder.DESC)
                .orderBy(exp to SortOrder.DESC)
                    .map { it.mapToMemberDTO() }
        }
    }

    fun fetchAllFromGuild(id: Long) {
        return transaction {
            select { guildId eq id }.map {
                it.mapToMemberDTO()
            }
        }
    }

    fun delete(id: Long) {
        transaction {
            deleteWhere { memberId eq id }
        }
    }

    fun deleteAllFromGuild(id: Long) {
        transaction {
            deleteWhere { guildId eq id }
        }
    }

}