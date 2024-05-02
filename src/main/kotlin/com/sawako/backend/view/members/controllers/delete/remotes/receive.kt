package com.sawako.backend.view.members.controllers.delete.remotes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeleteMemberReceive(
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long
)

@Serializable
data class DeleteMemberByOwnId(
    val id: Long
)
