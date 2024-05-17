package com.sawako.backend.view.users.controllers.fetch.all

import com.sawako.backend.domain.users.UsersService
import com.sawako.backend.view.users.controllers.fetch.all.remotes.FetchUsers
import com.sawako.backend.view.users.controllers.fetch.all.remotes.FetchUsersResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchUsers: suspend PipelineContext<Unit, ApplicationCall>.(FetchUsers) -> Unit = {
    call.respond(
        HttpStatusCode.Created,
        FetchUsersResponse(
            when (it.all) {
                true -> UsersService.getUsers(1, Int.MAX_VALUE)
                false -> UsersService.getUsers(it.page, it.size)
            }
        )
    )
}