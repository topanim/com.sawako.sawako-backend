package com.sawako.backend.view.members.controllers.fetch.all

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchMembersReceive
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchMembersResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val getMembers: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchMembersReceive>()
    call.respond(
        HttpStatusCode.OK,
        FetchMembersResponse(
            MembersService.getMembers(receive.page, receive.size)
        )
    )
}