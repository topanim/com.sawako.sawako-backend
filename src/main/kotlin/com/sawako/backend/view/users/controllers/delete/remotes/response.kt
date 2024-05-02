package com.sawako.backend.view.users.controllers.delete.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserResponse(
    val data: Unit = Unit
) : BaseResponse(
    MetaResponse(
        message = "User deleted successfully"
    )
)
