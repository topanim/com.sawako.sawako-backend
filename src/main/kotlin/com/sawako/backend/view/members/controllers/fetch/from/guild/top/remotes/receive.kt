package com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchGuildTopReceive(
    val id: Long,
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = false
)