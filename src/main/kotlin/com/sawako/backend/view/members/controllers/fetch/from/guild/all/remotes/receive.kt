package com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchMembersFromGuildReceive(
    val id: Long,
    val page: Int = 1,
    val size: Int = 10,
    val all: Boolean = true

)