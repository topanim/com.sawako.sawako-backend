package com.sawako.backend.view.members.controllers.delete.from.guild.remotes

import com.sawako.backend.view.members.RMembersByGuild
import io.ktor.resources.*

@Resource("")
class DeleteMembersByGuild(
    val parent: RMembersByGuild
)