package com.sawako.backend.view.members.controllers.fetch.one.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchMemberReceive(
    val guildId: Long,
    val userId: Long
)
