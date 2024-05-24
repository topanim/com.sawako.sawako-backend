package com.sawako.backend.view.members.controllers.delete.from.guild

import com.sawako.backend.domain.members.MembersService
import com.sawako.backend.view.members.controllers.delete.from.guild.remotes.DeleteMembersByGuild
import com.sawako.backend.view.members.controllers.delete.from.guild.remotes.DeleteMembersByGuildResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

val deleteMembersByGuild: suspend PipelineContext<Unit, ApplicationCall>.(DeleteMembersByGuild) -> Unit = {
    MembersService.deleteMembersFrom(it.parent.parent.guildId)
    call.respond(HttpStatusCode.OK, DeleteMembersByGuildResponse())
}
