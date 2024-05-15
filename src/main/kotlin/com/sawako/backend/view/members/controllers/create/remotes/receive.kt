package com.sawako.backend.view.members.controllers.create.remotes

import com.sawako.backend.view.members.RMembers
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("")
class CreateMember(
    val parent: RMembers = RMembers(),
)

@Serializable
class CreateMemberBodyReceive(
    val guildId: Long,
    val userId: Long
)

