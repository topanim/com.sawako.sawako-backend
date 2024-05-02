package com.sawako.backend.view.guilds.controllers.fetch.one

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.fetch.one.remotes.FetchGuildReceive
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val guild = call.receive<FetchGuildReceive>()
    call.respond(HttpStatusCode.OK, GuildsService.getGuild(guild.id))
}