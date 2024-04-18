package com.sawako.backend.features.members.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberUpdateExpReceiveRemote(
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long,
    val quantity: Int
)
