package com.sawako.backend.view.guilds.controllers.create

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.create.remotes.CreateGuild
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val createGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val guild = call.receive<CreateGuild>()
    GuildsService.createGuild(guild.id)
    call.respond(HttpStatusCode.Created)
}