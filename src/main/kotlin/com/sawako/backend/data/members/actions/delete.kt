package com.sawako.backend.data.members.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.members.Members
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.select




suspend fun Members.delete(guildId: Long, userId: Long): Unit = dbQuery {
    deleteWhere { (Members.guildId eq guildId) and (Members.userId eq userId) }
}

suspend fun Members.deleteFromGuild(guildId: Long) = dbQuery {
    Members.deleteWhere { this.guildId eq guildId }
}