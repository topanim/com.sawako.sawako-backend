package com.sawako.backend.view.guilds.controllers.fetch.one

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.fetch.one.remotes.FetchGuild
import com.sawako.backend.view.guilds.controllers.fetch.one.remotes.FetchGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchGuild: suspend PipelineContext<Unit, ApplicationCall>.(FetchGuild) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        FetchGuildResponse(
            GuildsService.getGuild(it.parent.guildId)
        )
    )
}