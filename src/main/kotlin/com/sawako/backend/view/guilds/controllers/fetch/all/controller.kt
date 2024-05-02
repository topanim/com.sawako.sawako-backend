package com.sawako.backend.view.guilds.controllers.fetch.all

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.fetch.all.remotes.FetchAllGuilds
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchGuilds: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val guild = call.receive<FetchAllGuilds>()
    call.respond(HttpStatusCode.OK, GuildsService.getGuilds(guild.page, guild.size))
}