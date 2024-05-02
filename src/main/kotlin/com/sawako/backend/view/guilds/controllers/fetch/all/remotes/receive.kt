package com.sawako.backend.view.guilds.controllers.fetch.all.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchAllGuilds(
    val page: Int,
    val size: Int
)

