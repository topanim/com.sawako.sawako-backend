package com.sawako.features.members

import com.sawako.database.members.Members
import com.sawako.features.members.models.MemberReceiveRemote

object MembersController {
    fun createMember(memberReceiveRemote: MemberReceiveRemote) {
        Members.insert(memberReceiveRemote)
    }

    fun getMember(id: Long) = Members.fetchOne(id)

    fun getMember(guildId: Long, userId: Long) = Members.fetchOne(guildId, userId)

    fun getMembers() = Members.fetchAll()

    fun getMembersFromGuild(id: Long) = Members.fetchAllFromGuild(id)

    fun getTop(id: Long) = Members.fetchGuildTop(id)

    fun deleteMember(id: Long) {
        Members.delete(id)
    }
}