package com.sawako.backend.database.users

import com.sawako.backend.database.DatabaseFactory.dbQuery
import com.sawako.backend.database.users.Users.userId
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

object UsersDAO {
    suspend fun insert(id: Long): Unit = dbQuery {
        Users.insert {
            it[userId] = id
        }
    }

    suspend fun fetchOne(id: Long): UserDTO = dbQuery {
        return@dbQuery Users.select { userId eq id }.single().mapToUserDTO()
    }

    suspend fun fetchAll(): List<UserDTO> = dbQuery {
        return@dbQuery try {
            Users.selectAll().map { it.mapToUserDTO() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun delete(id: Long) = dbQuery {
           Users.deleteWhere { userId eq id }
    }
}