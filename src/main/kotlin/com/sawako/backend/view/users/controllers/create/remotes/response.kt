package com.sawako.backend.view.users.controllers.create.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class CreateUserResponse(
    val data: Unit = Unit,
    @Transient private val metaBuilder: MetaResponse.() -> Unit = { }
) : BaseResponse(
    MetaResponse(
        message = "User created successfully",
        builder = metaBuilder
    )
)