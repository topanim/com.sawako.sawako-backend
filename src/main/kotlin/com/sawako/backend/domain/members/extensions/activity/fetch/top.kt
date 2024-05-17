package com.sawako.backend.domain.members.extensions.activity.fetch

import com.sawako.backend.data.members.Members
import com.sawako.backend.data.members.actions.top
import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.domain.members.toListMemberDTO

suspend fun MembersService.getGuildTop(guildId: Long, page: Int, size: Int) =
    Members.top(
        guildId,
        size,
        (page * size).toLong()
    ).toListMemberDTO()