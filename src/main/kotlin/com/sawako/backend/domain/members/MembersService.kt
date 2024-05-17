package com.sawako.backend.domain.members

import com.sawako.backend.data.members.Members
import com.sawako.backend.data.members.actions.*
import org.jetbrains.exposed.sql.Op

object MembersService {

    suspend fun createMember(guildId: Long, userId: Long) = Members.create(guildId, userId)

    suspend fun getMember(id: Long): MemberDTO = Members.one(id).toMemberDTO()

    suspend fun getMember(guildId: Long, userId: Long): MemberDTO =
        Members.one(guildId, userId).toMemberDTO()

    suspend fun getMembers(page: Int, size: Int): List<MemberDTO> = Members.all(
        size,
        (page.minus(1) * size).toLong()
    ) { Op.TRUE }.toListMemberDTO()

    suspend fun getMembersFromGuild(guildId: Long, page: Int, size: Int): List<MemberDTO> = Members.fromGuild(
        guildId,
        size,
        (page.minus(1) * size).toLong()
    ).toListMemberDTO()

    suspend fun getMembers(memberIds: List<Long>): List<MemberDTO> =
        Members.many(memberIds).toListMemberDTO()

    suspend fun deleteMember(guildId: Long, userId: Long) = Members.delete(guildId, userId)

    suspend fun deleteMember(id: Long) = Members.delete(id)

    suspend fun deleteMembersFrom(guildId: Long) = Members.deleteFromGuild(guildId)

}