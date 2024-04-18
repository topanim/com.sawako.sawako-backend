package com.sawako.backend.features.members.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MemberUpdateBioReceiveRemote(
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long,
    val name: String?,
    val birthdate: String?,
    val gender: String?,
    val about: String?
)

