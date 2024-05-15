package com.sawako.backend.view.guilds.controllers.delete.remotes

import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class DeleteGuildResponse(
    val data: Unit = Unit
) : BaseResponse(
    MetaResponse(
        message = "Guild deleted successfully"
    )
)