package com.sawako.backend.data.members.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.members.Members
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

suspend fun Members.one(guildId: Long, userId: Long) = dbQuery {
    select { (Members.guildId eq guildId) and (Members.userId eq userId) }.single()
}

suspend fun Members.fromGuild(guildId: Long, limit: Int = Int.MAX_VALUE, offset: Long = 0) = dbQuery {
    select { Members.guildId eq guildId }
        .limit(limit, offset)
        .toList()
}

suspend fun Members.top(guildId: Long, limit: Int = Int.MAX_VALUE, offset: Long = 0) = dbQuery {
    select { Members.guildId eq guildId }
        .orderBy(lvl to SortOrder.DESC)
        .orderBy(exp to SortOrder.DESC)
        .limit(limit, offset)
        .toList()
}
