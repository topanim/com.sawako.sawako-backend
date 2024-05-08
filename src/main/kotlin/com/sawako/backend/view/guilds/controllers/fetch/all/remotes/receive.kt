package com.sawako.backend.view.guilds.controllers.fetch.all.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchGuildsReceive(
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true
)

