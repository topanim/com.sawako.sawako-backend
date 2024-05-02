package com.sawako.backend.data.members.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.members.Members
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere

suspend fun deleteGuildMembers(guildId: Long) = dbQuery {
    Members.deleteWhere { this.guildId eq guildId }
}