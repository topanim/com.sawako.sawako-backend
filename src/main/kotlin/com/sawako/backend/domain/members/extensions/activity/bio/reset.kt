package com.sawako.backend.domain.members.extensions.activity.bio

import com.sawako.backend.data.members.Members
import com.sawako.backend.data.members.actions.upd
import com.sawako.backend.domain.members.MemberDTO
import com.sawako.backend.domain.members.MembersService

suspend fun MembersService.resetBio(guildId: Long, userId: Long): MemberDTO {

    Members.upd(
        guildId = guildId,
        userId = userId,
        name = Members.name.defaultValueInDb()!!.toString(),
        birthdate = Members.birthdate.defaultValueInDb()!!.toString(),
        gender = Members.gender.defaultValueInDb()!!.toString(),
        about = Members.about.defaultValueInDb()!!.toString()
    )

    return getMember(guildId, userId)
}