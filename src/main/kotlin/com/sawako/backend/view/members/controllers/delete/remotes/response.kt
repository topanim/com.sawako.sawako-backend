package com.sawako.backend.view.members.controllers.delete.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class DeleteMemberResponse(
    val data: Unit = Unit
) : BaseResponse(
    MetaResponse(
        message = "Member deleted successfully",
    )
)

