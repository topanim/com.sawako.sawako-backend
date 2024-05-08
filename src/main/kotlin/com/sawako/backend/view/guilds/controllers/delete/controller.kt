package com.sawako.backend.view.guilds.controllers.delete

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuildReceive
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<DeleteGuildReceive>()
    GuildsService.deleteGuild(receive.id)
    call.respond(HttpStatusCode.OK, DeleteGuildResponse())
}