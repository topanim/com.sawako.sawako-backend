package com.sawako.backend.view.users.controllers.fetch.all.remotes

import com.sawako.backend.domain.users.UserDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class FetchUsersResponse(
    val data: List<UserDTO>
) : BaseResponse(
    MetaResponse(
        message = "Users fetched successfully"
    )
)

