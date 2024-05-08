package com.sawako.backend.view.members.controllers.fetch.from.guild.top

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.domain.members.extensions.activity.fetch.getGuildTop
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes.FetchGuildTopReceive
import com.sawako.backend.view.members.controllers.fetch.from.guild.top.remotes.FetchGuildTopResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val getGuildTop: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<FetchGuildTopReceive>()
    call.respond(
        HttpStatusCode.OK,
        FetchGuildTopResponse(
            when (receive.all) {
                true -> MembersService.getGuildTop(receive.id, 1, Int.MAX_VALUE)
                false -> MembersService.getGuildTop(receive.id, receive.page, receive.size)
            }
        )
    )
}