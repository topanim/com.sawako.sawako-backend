package com.sawako.features.members

import com.sawako.features.members.models.MemberReceiveRemote
import com.sawako.features.members.models.UpdateMemberBioReceiveRemote
import com.sawako.features.members.models.UpdateMemberWalletReceiveRemote
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
            call.parameters["guild_id"]?.toLong()?.let {
                call.respond(HttpStatusCode.OK,
                    MembersController.getTop(it)
                )
            }

            call.respond(HttpStatusCode.BadRequest, "Bad Request")
        }

        get("/members/one/") {
            val receiveRemote= call.receive<MemberReceiveRemote>()
            call.respond(HttpStatusCode.OK, MembersController.getMember(receiveRemote))
//            call.respond(HttpStatusCode.BadRequest, "Bad Request")
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

        post("/members/update/bio") {
            val receiveRemote = call.receive<UpdateMemberBioReceiveRemote>()
            call.respond(HttpStatusCode.OK, MembersController.updateBio(receiveRemote))
        }

        post("/members/update/wallet") {
            val receiveRemote = call.receive<UpdateMemberWalletReceiveRemote>()
            MembersController.updateWallet(receiveRemote)
            call.respond(HttpStatusCode.OK, "Updated successfully")
        }

        post("/members/bio/reset") {
            val receiveRemote = call.receive<MemberReceiveRemote>()
            call.respond(HttpStatusCode.OK, MembersController.resetBio(receiveRemote))
        }

        post("/members/{id}/delete" ) {
            call.parameters["id"]?.toLong()?.let {
                try {
                    MembersController.deleteMember(it)
                    call.respond(HttpStatusCode.OK, "Deleted successfully")
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "Deletion failed")
                }
            }
        }
    }
}
