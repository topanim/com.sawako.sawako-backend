package com.sawako.backend.view.members

import com.sawako.backend.view.members.controllers.create.createMember
import com.sawako.backend.view.members.controllers.create.remotes.CreateMember
import com.sawako.backend.view.members.controllers.delete.deleteMember
import com.sawako.backend.view.members.controllers.delete.remotes.DeleteMember
import com.sawako.backend.view.members.controllers.fetch.all.fetchMembers
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchMembers
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.fetchMembersByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes.FetchMembersByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.one.fetchMemberByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.one.remotes.FetchMemberByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.fetchMembersTopByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes.FetchMembersTopByGuild
import io.ktor.server.resources.*
import io.ktor.server.routing.Routing

fun Routing.members() {
    post<CreateMember>(createMember)

    get<FetchMembers>(fetchMembers)

    get<FetchMembersByGuild>(fetchMembersByGuild)

    get<FetchMemberByGuild>(fetchMemberByGuild)

    get<FetchMembersTopByGuild>(fetchMembersTopByGuild)

    delete<DeleteMember>(deleteMember)

//    post("$router/marry")

//    post("$router/divorce")

//    post("$router/update/exp")

//    post("$router/update/bio")

//    post("$router/update/wallet")

//    post("$router/reset/bio")

}

