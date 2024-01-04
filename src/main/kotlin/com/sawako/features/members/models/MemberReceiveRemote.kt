package com.sawako.features.members.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberReceiveRemote(
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long
)
