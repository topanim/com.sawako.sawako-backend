package com.sawako.backend.view.members.controllers.fetch.one.remotes

import com.sawako.backend.domain.members.MemberDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable


@Serializable
class FetchMemberResponse(
    val data: MemberDTO
) : BaseResponse(
    MetaResponse(
        message = "Member fetched successfully",
    )
)
