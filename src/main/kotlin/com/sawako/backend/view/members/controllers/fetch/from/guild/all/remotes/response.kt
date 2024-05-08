package com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes

import com.sawako.backend.domain.members.MemberDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class FetchMembersFromGuildResponse(
    val data: List<MemberDTO>
) : BaseResponse(
    MetaResponse(
        message = "Members fetched successfully",
    )
)