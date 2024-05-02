package com.sawako.backend.view.users.controllers.fetch.all

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.fetch.all.remotes.FetchUsersReceive
import com.sawako.backend.view.users.controllers.fetch.all.remotes.FetchUsersResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchUsers: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchUsersReceive>()
    call.respond(
        HttpStatusCode.Created,
        FetchUsersResponse(
            UsersService.getUsers(receive.page, receive.size)
        )
    )
}