package com.sawako.backend.view.users.controllers.delete

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.delete.remotes.DeleteUserReceive
import com.sawako.backend.view.users.controllers.delete.remotes.DeleteUserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteUser: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<DeleteUserReceive>()
    UsersService.deleteUser(receive.id)
    call.respond(HttpStatusCode.Created, DeleteUserResponse())
}