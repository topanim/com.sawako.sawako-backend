package com.sawako.backend.view.members.controllers.fetch.all

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchAllMembersReceive
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchAllMembersResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val getMembers: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchAllMembersReceive>()
    call.respond(
        HttpStatusCode.OK,
        FetchAllMembersResponse(
            MembersService.getMembers(receive.page, receive.size)
        )
    )
}