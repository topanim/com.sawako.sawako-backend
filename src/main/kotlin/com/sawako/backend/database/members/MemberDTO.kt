package com.sawako.backend.database.members

import com.sawako.backend.database.members.Members.about
import com.sawako.backend.database.members.Members.birthdate
import com.sawako.backend.database.members.Members.exp
import com.sawako.backend.database.members.Members.gender
import com.sawako.backend.database.members.Members.guildId
import com.sawako.backend.database.members.Members.lover
import com.sawako.backend.database.members.Members.lvl
import com.sawako.backend.database.members.Members.memberId
import com.sawako.backend.database.members.Members.name
import com.sawako.backend.database.members.Members.upExp
import com.sawako.backend.database.members.Members.userId
import com.sawako.backend.database.members.Members.wallet
import com.sawako.backend.utils.extensions.default
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow

@Serializable
data class MemberDTO(
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
    val wallet: Int,
)

data class NewActivity(
    val lvl: Int,
    val upExp: Int
)

fun ResultRow.mapToMemberDTO(): com.sawako.backend.database.members.MemberDTO {
    return com.sawako.backend.database.members.MemberDTO(
        memberId = this[memberId],
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
