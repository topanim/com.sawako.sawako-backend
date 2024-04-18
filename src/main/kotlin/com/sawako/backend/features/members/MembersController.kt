package com.sawako.backend.features.members

import com.sawako.backend.database.members.MemberDTO
import com.sawako.backend.database.members.MembersDAO
import com.sawako.backend.features.guilds.models.GuildReceiveRemote
import com.sawako.backend.features.members.models.*

object MembersController {
    suspend fun createMember(receiveRemote: MemberReceiveRemote) =
        MembersDAO.insert(receiveRemote.guildId, receiveRemote.userId)

    suspend fun getMember(receiveRemote: MemberByOwnIdReceiveRemote) =
        MembersDAO.fetchOne(receiveRemote.id)

    suspend fun getMember(receiveRemote: MemberReceiveRemote) =
        MembersDAO.fetchOne(receiveRemote.guildId, receiveRemote.userId)

    suspend fun getMembers() = MembersDAO.fetchAll()

    suspend fun getGuildMembers(receiveRemote: GuildReceiveRemote) =
        MembersDAO.fetchGuildMembers(receiveRemote.id)

    suspend fun getTop(receiveRemote: GuildReceiveRemote) =
        MembersDAO.fetchGuildTop(receiveRemote.id)

    suspend fun marry(receiveRemotes: List<MemberReceiveRemote>) =
        MembersDAO.marry(
            receiveRemotes.first().guildId,
            receiveRemotes.first().userId,
            receiveRemotes.last().guildId,
            receiveRemotes.last().userId
        )

    suspend fun divorce(receiveRemote: MemberReceiveRemote) =
        MembersDAO.divorce(receiveRemote.guildId, receiveRemote.userId)

    suspend fun updateExpAdd(receiveRemote: MemberUpdateExpReceiveRemote): com.sawako.backend.database.members.MemberDTO =
        MembersDAO.updateExp(receiveRemote.guildId, receiveRemote.userId, receiveRemote.quantity)

    suspend fun updateBio(receiveRemote: MemberUpdateBioReceiveRemote): com.sawako.backend.database.members.MemberDTO =
        MembersDAO.updateBio(
            receiveRemote.guildId,
            receiveRemote.userId,
            receiveRemote.name,
            receiveRemote.birthdate,
            receiveRemote.gender,
            receiveRemote.about
        )

    suspend fun updateWallet(receiveRemote: MemberUpdateWalletReceiveRemote) =
        MembersDAO.updateWallet(receiveRemote.guildId, receiveRemote.userId, receiveRemote.amount)

    suspend fun resetBio(receiveRemote: MemberReceiveRemote) =
        MembersDAO.resetBio(receiveRemote.guildId, receiveRemote.userId)

    suspend fun deleteMember(receiveRemote: MemberByOwnIdReceiveRemote) =
        MembersDAO.delete(receiveRemote.id)
}