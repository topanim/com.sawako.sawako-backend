package com.sawako.features.members

import com.sawako.features.members.models.MemberReceiveRemote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureMembersRouting() {
    routing {
        get("/members/") {
            call.respond(HttpStatusCode.OK,
                MembersController.getMembers()
            )
        }

        get("/members/top") {
            call.parameters["id"]?.toLong()?.let {
                call.respond(HttpStatusCode.OK,
                    MembersController.getTop(it)
                )
            }

            call.respond(HttpStatusCode.BadRequest, "Bad Request")

        }

        get("/members/one/") {
            val guildId = call.parameters["guild_id"]?.toLong()
            val userId = call.parameters["user_id"]?.toLong()

            if (guildId != null && userId != null) {
                call.respond(HttpStatusCode.OK, MembersController.getMember(guildId, userId))
            }

            call.respond(HttpStatusCode.BadRequest, "Bad Request")
        }

        get("/members/from/{id}") {
            call.parameters["id"]?.toLong()?.let {
                call.respond(HttpStatusCode.OK,
                    MembersController.getMembersFromGuild(it)
                )
            }

            call.respond(HttpStatusCode.BadRequest, "Bad Request")
        }

        post("/members/create") {
            val member = call.receive<MemberReceiveRemote>()

            try {
                MembersController.createMember(member)
                call.respond(HttpStatusCode.Created, "Created successfully")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Creation Failed")
            }

        }

        post("/members/{id}/delete" ) {
            call.parameters["id"]?.toLong()?.let {
                println(it)

                try {
                    MembersController.deleteMember(it)
                    call.respond(HttpStatusCode.OK, "Deleted successfully")
                } catch (e: Exception) {
                    println(e)
                    call.respond(HttpStatusCode.BadRequest, "Deletion failed")
                }
            }
        }
    }
}
