package com.sawako.backend.view.members.controllers.fetch.all

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchMembers
import com.sawako.backend.view.members.controllers.fetch.all.remotes.FetchMembersResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchMembers: suspend PipelineContext<Unit, ApplicationCall>.(FetchMembers) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        FetchMembersResponse(
            when (it.all) {
                true -> MembersService.getMembers(1, Int.MAX_VALUE)
                false -> MembersService.getMembers(it.page, it.size)
            }
        )
    )
}