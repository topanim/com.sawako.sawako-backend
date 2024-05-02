package com.sawako.backend.view.members.controllers.create.remotes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateMemberReceive(
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long
)

