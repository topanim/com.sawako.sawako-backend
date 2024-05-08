package com.sawako.backend.view.members.controllers.fetch.from.guild.all

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes.FetchMembersFromGuildReceive
import com.sawako.backend.view.members.controllers.fetch.from.guild.all.remotes.FetchMembersFromGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val getMembersFromGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchMembersFromGuildReceive>()
    call.respond(
        HttpStatusCode.OK,
        FetchMembersFromGuildResponse(
            when (receive.all) {
                true -> MembersService.getMembers(1, Int.MAX_VALUE)
                false -> MembersService.getMembers(receive.id, receive.page, receive.size)
            }
        )
    )
}