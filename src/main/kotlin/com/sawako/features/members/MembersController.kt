package com.sawako.features.members

import com.sawako.database.members.Members
import com.sawako.features.members.models.MemberReceiveRemote

object MembersController {
    fun createMember(memberReceiveRemote: MemberReceiveRemote) {
        Members.insert(memberReceiveRemote)
    }

    fun getMember(id: Long) = Members.fetchOne(id)

    fun getMembers() = Members.fetchAll()
}