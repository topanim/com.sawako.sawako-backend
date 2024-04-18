package com.sawako.backend.database.users

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

object Users : Table("users") {
    val userId: Column<Long> = long("id")

    override val primaryKey = PrimaryKey(userId, name = "PK_Users_ID")
}