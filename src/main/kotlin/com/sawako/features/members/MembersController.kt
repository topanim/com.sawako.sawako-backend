package com.sawako.features.members

import com.sawako.database.members.MemberDTO
import com.sawako.database.members.Members
import com.sawako.features.members.models.MemberReceiveRemote
import com.sawako.features.members.models.UpdateMemberBioReceiveRemote
import com.sawako.features.members.models.UpdateMemberWalletReceiveRemote

object MembersController {
    fun createMember(receiveRemote: MemberReceiveRemote) {
        Members.insert(receiveRemote)
    }

    fun getMember(id: Long) = Members.fetchOne(id)

    fun getMember(receiveRemote: MemberReceiveRemote) = Members.fetchOne(receiveRemote)

    fun getMembers() = Members.fetchAll()

    fun getMembersFromGuild(id: Long) = Members.fetchAllFromGuild(id)

    fun getTop(id: Long) = Members.fetchGuildTop(id)

    fun updateBio(receiveRemote: UpdateMemberBioReceiveRemote): MemberDTO {
        return Members.updateBio(receiveRemote)
    }

    fun updateWallet(receiveRemote: UpdateMemberWalletReceiveRemote) {
        return Members.updateWallet(receiveRemote)
    }

    fun resetBio(receiveRemote: MemberReceiveRemote) = Members.resetBio(receiveRemote)

    fun deleteMember(id: Long) {
        Members.delete(id)
    }
}