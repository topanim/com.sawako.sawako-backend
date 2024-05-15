package com.sawako.backend.view.members.controllers.create.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class CreateMemberResponse(
    val data: Unit = Unit
) : BaseResponse(
    MetaResponse(
        message = "Member created successfully",
    )
)
