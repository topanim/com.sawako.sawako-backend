package com.sawako.backend.view.members.controllers.fetch.from.guild.top

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.domain.members.extensions.activity.fetch.getGuildTop
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes.FetchGuildTopResponse
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes.FetchMembersTopByGuild
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchMembersTopByGuild: suspend PipelineContext<Unit, ApplicationCall>.(FetchMembersTopByGuild) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        FetchGuildTopResponse(
            when (it.all) {
                true -> MembersService.getGuildTop(it.parent.parent.guildId, 1, Int.MAX_VALUE)
                false -> MembersService.getGuildTop(it.parent.parent.guildId, it.page, it.size)
            }
        )
    )
}