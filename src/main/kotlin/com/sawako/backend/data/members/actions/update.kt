package com.sawako.backend.data.members.actions

import com.sawako.backend.data.DatabaseFactory.dbQuery
import com.sawako.backend.data.members.Members
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.statements.UpdateStatement
import org.jetbrains.exposed.sql.update

suspend fun Members.upd(
    id: Long,
    name: String? = null,
    gender: String? = null,
    birthdate: String? = null,
    about: String? = null,
    lover: Long? = null,
    exp: Int? = null,
    lvl: Int? = null,
    upExp: Int? = null,
    wallet: Int? = null
): Unit = dbQuery {
    update(
        { Members.id eq id }
    ) { upd ->
        name?.let { upd[Members.name] = name }
        gender?.let { upd[Members.gender] = gender }
        birthdate?.let { upd[Members.birthdate] = birthdate }
        about?.let { upd[Members.about] = about }
        lover?.let { upd[Members.lover] = lover }
        exp?.let { upd[Members.exp] = exp }
        lvl?.let { upd[Members.lvl] = lvl }
        upExp?.let { upd[Members.upExp] = upExp }
        wallet?.let { upd[Members.wallet] = wallet }
    }
}

suspend fun Members.upd(
    guildId: Long,
    userId: Long,
    name: String? = null,
    gender: String? = null,
    birthdate: String? = null,
    about: String? = null,
    exp: Members.(UpdateStatement) -> Unit = {},
    lvl: Members.(UpdateStatement) -> Unit = {},
    upExp: Members.(UpdateStatement) -> Unit = {},
    wallet: Members.(UpdateStatement) -> Unit = {}
): Unit = dbQuery {
    update(
        { (Members.userId eq userId) and (Members.guildId eq guildId) }
    ) { upd ->
        name?.let { upd[Members.name] = name }
        gender?.let { upd[Members.gender] = gender }
        birthdate?.let { upd[Members.birthdate] = birthdate }
        about?.let { upd[Members.about] = about }
        exp(upd)
        lvl(upd)
        upExp(upd)
        wallet(upd)
    }
}