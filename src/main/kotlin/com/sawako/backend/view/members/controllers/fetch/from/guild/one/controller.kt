package com.sawako.backend.view.members.controllers.fetch.from.guild.one

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.from.guild.one.remotes.FetchMemberByGuild
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchMemberByGuild: suspend PipelineContext<Unit, ApplicationCall>.(FetchMemberByGuild) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        MembersService.getMember(it.parent.userId)
    )
}