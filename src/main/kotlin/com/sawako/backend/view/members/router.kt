package com.sawako.backend.view.members

import com.sawako.backend.view.members.controllers.create.createMember
import com.sawako.backend.view.members.controllers.delete.deleteMember
import com.sawako.backend.view.members.controllers.fetch.all.getMembers
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.getMembersFromGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.getGuildTop
import com.sawako.backend.view.members.controllers.fetch.one.getMember
import io.ktor.server.routing.*

const val router = "/guilds/members"
const val secondaryRouter = "/guilds/{guildId}/members"

fun Routing.members() {
    get("$router/", getMembers)

    get("$secondaryRouter/", getMembersFromGuild)

    get("$secondaryRouter/{userId}", getMember)

    get("$secondaryRouter/top", getGuildTop)

    post("$secondaryRouter/create", createMember)

    delete("$secondaryRouter/{userId}/delete", deleteMember)

//    post("$router/marry")

//    post("$router/divorce")

//    post("$router/update/exp")

//    post("$router/update/bio")

//    post("$router/update/wallet")

//    post("$router/reset/bio")

}

