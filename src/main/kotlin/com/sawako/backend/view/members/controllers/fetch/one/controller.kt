package com.sawako.backend.view.members.controllers.fetch.one

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.one.remotes.FetchMemberReceive
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val getMember: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchMemberReceive>()
    call.respond(
        HttpStatusCode.OK,
        MembersService.getMember(receive.guildId, receive.userId)
    )
}