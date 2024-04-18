package com.sawako.backend.database.guilds

import com.sawako.backend.database.DatabaseFactory.dbQuery
import com.sawako.backend.database.guilds.Guilds.guildId
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll


object GuildsDAO {
    suspend fun insert(id: Long, guildSettings: String): Unit = dbQuery {
        Guilds.insert {
            it[guildId] = id
            it[settings] = guildSettings
        }
    }

    suspend fun fetchOne(id: Long): GuildDTO = dbQuery {
        return@dbQuery Guilds.select { guildId eq id }.single().mapToGuildDTO()
    }

    suspend fun fetchAll(): List<GuildDTO> = dbQuery {
        return@dbQuery try {
            Guilds.selectAll().map { it.mapToGuildDTO() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun delete(id: Long): Unit = dbQuery {
        Guilds.deleteWhere { guildId eq id }
    }

}