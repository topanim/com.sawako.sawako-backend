package com.sawako.backend.domain.members.extensions.activity.bio

import com.sawako.backend.data.members.Members
import com.sawako.backend.data.members.actions.upd
import com.sawako.backend.domain.members.MemberDTO
import com.sawako.backend.domain.members.MembersService

suspend fun MembersService.updateBio(
    guildId: Long,
    userId: Long,
    name: String? = null,
    birthdate: String? = null,
    gender: String? = null,
    about: String? = null
): MemberDTO {
    Members.upd(
        guildId = guildId,
        userId = userId,
        name = name,
        birthdate = birthdate,
        gender = gender,
        about = about
    )

    return getMember(guildId, userId)
}