package com.sawako.backend.view.members

import com.sawako.backend.view.guilds.RGuilds
import io.ktor.resources.*

@Resource("/members")
class RMembers {

    @Resource("{id}")
    class One(
        val parent: RMembers = RMembers(),

        // params
        val userId: Long
    )
}

@Resource("members")
class RMembersByGuild(
    val parent: RGuilds.One,
) {

    @Resource("{userId}")
    class One(
        val parent: RMembersByGuild,

        // params
        val userId: Long
    )
}
