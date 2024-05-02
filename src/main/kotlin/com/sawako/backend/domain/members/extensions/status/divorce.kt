package com.sawako.backend.domain.members.extensions.status

suspend fun divorce(guildID: Long, userID: Long) = {
//    val member = Members
//        .select { (guildId eq guildID) and (userId eq userID) }
//        .single()
//
//    member[lover]?.let {
//        Members.update({
//            (memberId eq member[memberId])
//            (memberId eq it)
//        }) { it[lover] = null }
//    }
}