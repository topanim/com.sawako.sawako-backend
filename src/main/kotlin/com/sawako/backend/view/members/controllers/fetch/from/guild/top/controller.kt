package com.sawako.backend.view.members.controllers.fetch.from.guild.top

import io.ktor.server.application.*
import io.ktor.util.pipeline.*

val getGuild: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
//    val guild = call.receive<GuildReceiveRemote>()
//    call.respond(
//        HttpStatusCode.OK,
//        controller.getGuild(guild)
//            .mapToGuildResponseRemote()
//    )
}