package com.sawako.backend.view.members.controllers.fetch.from.guild.one.remotes

import com.sawako.backend.view.members.RMembers
import io.ktor.resources.*
import kotlinx.serialization.Serializable


@Resource("/")
class FetchMemberByGuild(
    val parent: RMembers.One
)

@Serializable
class FetchGuildMemberReceive()
