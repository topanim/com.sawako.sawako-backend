package com.sawako.backend.view.guilds.controllers.create.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class CreateGuildResponse(
    val data: Unit = Unit,
    @Transient private val metaBuilder: MetaResponse.() -> Unit = { }
) : BaseResponse(
    MetaResponse(
        message = "Guild created successfully",
        builder = metaBuilder
    )
)