package com.sawako.backend.domain.members

import com.sawako.backend.data.members.Members.about
import com.sawako.backend.data.members.Members.birthdate
import com.sawako.backend.data.members.Members.exp
import com.sawako.backend.data.members.Members.gender
import com.sawako.backend.data.members.Members.guildId
import com.sawako.backend.data.members.Members.id
import com.sawako.backend.data.members.Members.lover
import com.sawako.backend.data.members.Members.lvl
import com.sawako.backend.data.members.Members.name
import com.sawako.backend.data.members.Members.upExp
import com.sawako.backend.data.members.Members.userId
import com.sawako.backend.data.members.Members.wallet
import com.sawako.backend.utils.extensions.default
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow

@Serializable
data class MemberDTO(
    @SerialName("id") val memberId: Long,
    val guildId: Long,
    val userId: Long,
    val name: String,
    val gender: String,
    val birthdate: String,
    val about: String,
    val lover: Long?,
    val exp: Int,
    val lvl: Int,
    val upExp: Int,
    val wallet: Int,
)

fun ResultRow.toMemberDTO(): MemberDTO {
    return MemberDTO(
        memberId = this[id],
        guildId = this[guildId],
        userId = this[userId],
        name = this[name].default("Не указано"),
        gender = this[gender].default("Не указано"),
        birthdate = this[birthdate].default("Не указано"),
        about = this[about].default("Отсутствует"),
        lover = this[lover],
        exp = this[exp],
        lvl = this[lvl],
        upExp = this[upExp],
        wallet = this[wallet]
    )
}

fun List<ResultRow>.toListMemberDTO(): List<MemberDTO> {
    return map { it.toMemberDTO() }
}
