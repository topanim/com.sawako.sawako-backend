package com.sawako.backend.view.users.controllers.create

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.create.remotes.CreateUserReceive
import com.sawako.backend.view.users.controllers.create.remotes.CreateUserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val createUser: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<CreateUserReceive>()
    UsersService.createUser(receive.id)
    call.respond(HttpStatusCode.Created, CreateUserResponse())
}