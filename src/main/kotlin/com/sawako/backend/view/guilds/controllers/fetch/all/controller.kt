package com.sawako.backend.view.guilds.controllers.fetch.all

import com.sawako.backend.domain.guilds.GuildsService
import com.sawako.backend.view.guilds.controllers.fetch.all.remotes.FetchGuilds
import com.sawako.backend.view.guilds.controllers.fetch.all.remotes.FetchGuildsResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val fetchGuilds: suspend PipelineContext<Unit, ApplicationCall>.(FetchGuilds) -> Unit = {
    call.respond(
        HttpStatusCode.OK,
        FetchGuildsResponse(
            when (it.all) {
                true -> GuildsService.getGuilds(1, Int.MAX_VALUE)
                false -> GuildsService.getGuilds(it.page, it.size)
            }
        )
    )
}