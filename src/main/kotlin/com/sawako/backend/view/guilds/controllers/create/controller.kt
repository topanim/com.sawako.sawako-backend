package com.sawako.backend.view.guilds.controllers.create

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.create.remotes.CreateGuild
import com.sawako.backend.view.guilds.controllers.create.remotes.CreateGuildReceive
import com.sawako.backend.view.guilds.controllers.create.remotes.CreateGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val createGuild: suspend PipelineContext<Unit, ApplicationCall>.(CreateGuild) -> Unit = {
    val receive: CreateGuildReceive = call.receive()
    try {
        GuildsService.createGuild(receive.id)
        call.respond(HttpStatusCode.Created, CreateGuildResponse())
    } catch (e: Exception) {
        call.respond(
            HttpStatusCode.Conflict,
            CreateGuildResponse {
                message = e.message.toString()
                status = HttpStatusCode.Conflict.value
            }
        )
    }


}