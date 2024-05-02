package com.sawako.backend.view.members.controllers.fetch.all.remotes

import com.sawako.backend.domain.guilds.GuildDTO
import com.sawako.backend.domain.members.MemberDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class FetchAllMembersResponse(
    val data: List<MemberDTO>
) : BaseResponse(
    MetaResponse(
        message = "Guilds fetched successfully",
    )
)
