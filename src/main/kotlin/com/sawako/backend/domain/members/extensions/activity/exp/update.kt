package com.sawako.backend.domain.members.extensions.activity.exp

suspend fun updateExp(
    guildID: Long,
    userID: Long,
    quantity: Int
)= {
//    val before = Members
//        .select { (guildId eq guildID) and (userId eq userID) }
//        .single()
//        .mapToMemberDTO()
//
//    Members.update({
//        (guildId eq guildID) and (userId eq userID)
//    }) {
//        (before.exp + quantity).let { newExp ->
//            it[exp] = newExp
//            calculateLvl(newExp).let { newActivity ->
//                it[lvl] = newActivity.lvl
//                it[upExp] = newActivity.upExp
//            }
//        }
//    }
//
//    Members
//        .select { (guildId eq guildID) and (userId eq userID) }
//        .single()
//        .mapToMemberDTO()
}