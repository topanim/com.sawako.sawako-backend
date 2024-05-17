package com.sawako.backend.view.members.controllers.fetch.from.guild.all

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes.FetchMembersByGuild
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes.FetchMembersFromGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchMembersByGuild: suspend PipelineContext<Unit, ApplicationCall>.(FetchMembersByGuild) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        FetchMembersFromGuildResponse(
            when (it.all) {
                true -> MembersService.getMembersFromGuild(it.parent.parent.guildId, 1, Int.MAX_VALUE)
                false -> MembersService.getMembersFromGuild(it.parent.parent.guildId, it.page, it.size)
            }
        )
    )
}