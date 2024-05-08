package com.sawako.backend.view.guilds.controllers.fetch.all.remotes

import com.sawako.backend.domain.guilds.GuildDTO
import com.sawako.backend.view.common.BaseResponse
import com.sawako.backend.view.common.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class FetchGuildsResponse(
    val data: List<GuildDTO>
) : BaseResponse(
    MetaResponse(
        message = "Guilds fetched successfully"
    )
)

