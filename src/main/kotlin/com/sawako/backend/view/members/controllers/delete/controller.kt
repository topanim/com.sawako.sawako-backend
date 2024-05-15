package com.sawako.backend.view.members.controllers.delete

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.delete.remotes.DeleteMember
import com.sawako.backend.view.members.controllers.delete.remotes.DeleteMemberResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteMember: suspend PipelineContext<Unit, ApplicationCall>.(DeleteMember) -> Unit = {
    MembersService.deleteMember(it.parent.parent.parent.guildId, it.parent.userId)
    call.respond(HttpStatusCode.OK, DeleteMemberResponse())
}