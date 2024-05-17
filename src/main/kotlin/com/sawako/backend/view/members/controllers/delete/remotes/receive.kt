package com.sawako.backend.view.members.controllers.delete.remotes

import com.sawako.backend.view.members.RMembersByGuild
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Resource("")
class DeleteMember(
    val parent: RMembersByGuild.One
)

@Serializable
class DeleteMemberReceive()
