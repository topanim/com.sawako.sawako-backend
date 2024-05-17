package com.sawako.backend.data.members.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.members.Members
import org.jetbrains.exposed.sql.insert

suspend fun Members.create(guildId: Long, userId: Long): Unit = dbQuery {
    Members.insert {
        it[this.guildId] = guildId
        it[this.userId] = userId
        it[upExp] = 50
    }
}