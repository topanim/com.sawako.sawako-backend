package com.sawako.backend.database.users

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val userId: Column<Long> = long("id")

    override val primaryKey = PrimaryKey(userId, name = "PK_Users_ID")
}