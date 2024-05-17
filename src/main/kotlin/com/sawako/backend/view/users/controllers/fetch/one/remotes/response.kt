package com.sawako.backend.view.users.controllers.fetch.one.remotes

import com.sawako.backend.domain.users.UserDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class FetchUserResponse(
    val data: UserDTO
) : BaseResponse(
    MetaResponse(
        message = "User fetched successfully"
    )
)
