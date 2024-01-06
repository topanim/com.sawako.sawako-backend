package com.sawako.database.users

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

object Users : Table("users") {
    val userId: Column<Long> = long("id")

    override val primaryKey = PrimaryKey(userId, name = "PK_Users_ID")

    fun insert(userDTO: UserDTO) {
        transaction {
            insert {
                it[userId] = userDTO.id
            }
        }
    }

    fun fetchOne(id: Long): UserDTO {
        return transaction {
            val user = select { userId eq id}.single()

            UserDTO(id = user[userId])
        }
    }

    fun fetchAll(): List<UserDTO> {
        return try {
            transaction {
                selectAll().map { it.mapToUserDTO() }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun delete(id: Long) {
        transaction {
            deleteWhere { userId eq id }
        }
    }
}