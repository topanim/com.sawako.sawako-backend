package com.sawako.backend.view.users.controllers.delete

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.delete.remotes.DeleteUser
import com.sawako.backend.view.users.controllers.delete.remotes.DeleteUserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteUser: suspend PipelineContext<Unit, ApplicationCall>.(DeleteUser) -> Unit = {
    UsersService.deleteUser(it.parent.userId)
    call.respond(HttpStatusCode.Created, DeleteUserResponse())
}