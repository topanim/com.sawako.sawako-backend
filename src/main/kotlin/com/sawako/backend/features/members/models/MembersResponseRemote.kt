package com.sawako.backend.features.members.models

import com.sawako.backend.database.members.MemberDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MembersResponseRemote(
    @SerialName("id") val memberId: Long,
    @SerialName("guild_id") val guildId: Long,
    @SerialName("user_id") val userId: Long,
    val name: String,
    val gender: String,
    val birthdate: String,
    val about: String,
    val lover: Long?,
    val exp: Int,
    val lvl: Int,
    @SerialName("up_exp") val upExp: Int,
    val wallet: Int
)

fun com.sawako.backend.database.members.MemberDTO.toResponseRemote() =
    MembersResponseRemote(
        memberId = memberId,
        guildId = guildId,
        userId = userId,
        name = name,
        gender = gender,
        birthdate = birthdate,
        about = about,
        lover = lover,
        exp = exp,
        lvl = lvl,
        upExp = upExp,
        wallet = wallet
    )
