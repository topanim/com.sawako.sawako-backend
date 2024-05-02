package com.sawako.backend.view.guilds.controllers.delete

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuild
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val guild = call.receive<DeleteGuild>()
    GuildsService.deleteGuild(guild.id)
    call.respond(HttpStatusCode.OK)
}