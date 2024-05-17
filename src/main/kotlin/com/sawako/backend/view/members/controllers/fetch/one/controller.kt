package com.sawako.backend.view.members.controllers.fetch.one

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.one.remotes.FetchMember
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchMember: suspend PipelineContext<Unit, ApplicationCall>.(FetchMember) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        MembersService.getMember(it.parent.userId)
    )
}