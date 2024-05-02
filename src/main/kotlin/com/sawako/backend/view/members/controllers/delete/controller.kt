package com.sawako.backend.view.members.controllers.delete

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.delete.remotes.DeleteMemberReceive
import com.sawako.backend.view.members.controllers.delete.remotes.DeleteMemberResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteMember: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit = {
    val receive = call.receive<DeleteMemberReceive>()
    MembersService.deleteMember(receive.guildId, receive.userId)
    call.respond(HttpStatusCode.OK, DeleteMemberResponse())
}