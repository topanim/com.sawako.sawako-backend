package com.sawako.backend.view.members

import com.sawako.backend.view.guilds.models.GuildReceiveRemote
import com.sawako.backend.view.members.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.configureMembersRouting() {
    get("/members/") {
        call.respond(
            HttpStatusCode.OK,
            MembersController.getMembers()
        )
    }

    get("/members/one") {
        val receiveRemote = call.receive<MemberReceiveRemote>()
        call.respond(HttpStatusCode.OK, MembersController.getMember(receiveRemote))
    }

    get("/members/from/{id}") {
        val guild = call.receive<GuildReceiveRemote>()
        call.respond(
            HttpStatusCode.OK,
            MembersController.getGuildMembers(guild)
        )
    }

    get("/members/from/{id}/top") {
        val guild = call.receive<GuildReceiveRemote>()
        call.respond(
            HttpStatusCode.OK,
            MembersController.getTop(guild)
        )
    }

    post("/members/create") {
        val member = call.receive<MemberReceiveRemote>()
        MembersController.createMember(member)
        call.respond(HttpStatusCode.Created, "Created successfully")
    }

    post("/members/marry") {
        val receiveRemotes = call.receive<List<MemberReceiveRemote>>()
        MembersController.marry(receiveRemotes)
        call.respond(HttpStatusCode.OK, "Married successfully")
    }

    post("/members/divorce") {
        val receiveRemote = call.receive<MemberReceiveRemote>()
        MembersController.divorce(receiveRemote)
        call.respond(HttpStatusCode.OK, "Divorce successfully")
    }

    post("/members/update/exp") {
        val receiveRemote = call.receive<MemberUpdateExpReceiveRemote>()
        call.respond(HttpStatusCode.OK, MembersController.updateExpAdd(receiveRemote))
    }

    post("/members/update/bio") {
        val receiveRemote = call.receive<MemberUpdateBioReceiveRemote>()
        call.respond(HttpStatusCode.OK, MembersController.updateBio(receiveRemote))
    }

    post("/members/update/wallet") {
        val receiveRemote = call.receive<MemberUpdateWalletReceiveRemote>()
        MembersController.updateWallet(receiveRemote)
        call.respond(HttpStatusCode.OK, "Updated successfully")
    }

    post("/members/reset/bio") {
        val receiveRemote = call.receive<MemberReceiveRemote>()
        call.respond(HttpStatusCode.OK, MembersController.resetBio(receiveRemote))
    }

    post("/members/{id}/delete") {
        val receiveRemote = call.receive<MemberByOwnIdReceiveRemote>()
        MembersController.deleteMember(receiveRemote)
        call.respond(HttpStatusCode.OK, "Deleted successfully")
    }
}

