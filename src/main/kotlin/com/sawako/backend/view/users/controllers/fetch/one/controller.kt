package com.sawako.backend.view.users.controllers.fetch.one

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.fetch.one.remotes.FetchUserReceive
import com.sawako.backend.view.users.controllers.fetch.one.remotes.FetchUserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchUser: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchUserReceive>()
    call.respond(
        HttpStatusCode.Created,
        FetchUserResponse(
            UsersService.getUser(receive.id)
        )
    )
}