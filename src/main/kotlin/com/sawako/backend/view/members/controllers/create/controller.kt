package com.sawako.backend.view.members.controllers.create

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.create.remotes.CreateMember
import com.sawako.backend.view.members.controllers.create.remotes.CreateMemberBodyReceive
import com.sawako.backend.view.members.controllers.create.remotes.CreateMemberResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val createMember: suspend PipelineContext<Unit, ApplicationCall>.(CreateMember) -> Unit = {
    val receive = call.receive<CreateMemberBodyReceive>()
    MembersService.createMember(receive.guildId, receive.userId)
    call.respond(HttpStatusCode.OK, CreateMemberResponse())
}