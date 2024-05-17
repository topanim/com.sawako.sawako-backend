package com.sawako.backend.view.guilds.controllers.delete

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuild
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteGuild: suspend PipelineContext<Unit, ApplicationCall>.(DeleteGuild) -> Unit = {
    GuildsService.deleteGuild(it.parent.guildId)
    call.respond(HttpStatusCode.OK, DeleteGuildResponse())
}