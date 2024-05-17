package com.sawako.backend.view.guilds.controllers.fetch.one.remotes

import com.sawako.backend.domain.guilds.GuildDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
class FetchGuildResponse(
    val data: GuildDTO
) : BaseResponse(
    MetaResponse(
        message = "Guild fetched successfully"
    )
)