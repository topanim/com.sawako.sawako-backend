package com.sawako.database.guilds

import com.sawako.database.users.UserDTO
import com.sawako.database.users.Users
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Guilds : Table("guilds") {
    val guildId: Column<Long> = long("id")
    val settings: Column<String> = text("settings")

    override val primaryKey = PrimaryKey(guildId, name = "PK_Guilds_ID")

    fun insert(guildDTO: GuildDTO) {
        transaction {
            insert {
                it[guildId] = guildDTO.id
                it[settings] = guildDTO.settings
            }
        }
    }

    fun fetchOne(id: Long): GuildDTO {
        return transaction {
             select { guildId eq id}.single().mapToGuildDTO()
        }
    }

    fun fetchAll(): List<GuildDTO> {
        return try {
            transaction {
                selectAll().map { it.mapToGuildDTO() }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}