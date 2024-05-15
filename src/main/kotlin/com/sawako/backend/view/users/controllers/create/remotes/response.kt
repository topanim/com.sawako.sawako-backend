package com.sawako.backend.view.users.controllers.create.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class CreateUserResponse(
    val data: Unit = Unit
) : BaseResponse(
    MetaResponse(
        message = "User created successfully"
    )
)