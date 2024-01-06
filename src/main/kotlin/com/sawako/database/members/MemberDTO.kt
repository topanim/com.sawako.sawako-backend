package com.sawako.database.members

import com.sawako.database.members.Members.about
import com.sawako.database.members.Members.birthdate
import com.sawako.database.members.Members.exp
import com.sawako.database.members.Members.gender
import com.sawako.database.members.Members.guildId
import com.sawako.database.members.Members.lover
import com.sawako.database.members.Members.lvl
import com.sawako.database.members.Members.memberId
import com.sawako.database.members.Members.name
import com.sawako.database.members.Members.upExp
import com.sawako.database.members.Members.userId
import com.sawako.database.members.Members.wallet
import com.sawako.utils.extensions.default
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

fun ResultRow.mapToMemberDTO(): MemberDTO {
    return MemberDTO(
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
