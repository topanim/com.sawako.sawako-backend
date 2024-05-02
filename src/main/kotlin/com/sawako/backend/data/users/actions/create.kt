package com.sawako.backend.data.users.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.users.Users
import org.jetbrains.exposed.sql.insert

suspend fun Users.create(id: Long) = dbQuery {
    this.insert {
        it[this.id] = id
    }
}