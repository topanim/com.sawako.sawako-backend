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

        get("/members/{id}") {
            call.parameters["id"]?.toLong()?.let {
                call.respond(HttpStatusCode.OK,
                    MembersController.getMember(it)
                )
            }

            call.respond(HttpStatusCode.OK, "Member not found")
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

        post("/members/create/pack") {
            val members = call.receive<List<MemberReceiveRemote>>()

            members.forEach { member ->
                try {
                    MembersController.createMember(member)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "Creation Failed")
                }
            }
            call.respond(HttpStatusCode.Created, "Created successfully")
        }
    }
}
