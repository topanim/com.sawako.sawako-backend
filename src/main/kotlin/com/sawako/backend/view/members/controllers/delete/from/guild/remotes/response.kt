package com.sawako.backend.view.members.controllers.delete.from.guild.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class DeleteMembersByGuildResponse(
    val data: Unit = Unit
) : BaseResponse(
    meta = MetaResponse(
        message = "Members deleted successfully"
    )
)