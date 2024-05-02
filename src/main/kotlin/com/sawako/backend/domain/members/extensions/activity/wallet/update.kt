package com.sawako.backend.domain.members.extensions.activity.wallet

import com.sawako.backend.data.members.Members
import com.sawako.backend.data.members.actions.upd
import com.sawako.backend.domain.members.MembersService
import org.jetbrains.exposed.sql.SqlExpressionBuilder.plus

suspend fun MembersService.updateWallet(guildId: Long, userId: Long, amount: Int) {
    Members.upd(
        guildId = guildId,
        userId = userId,
        wallet = { it[wallet] = wallet + amount }
    )
}