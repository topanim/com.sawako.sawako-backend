package com.sawako.backend.features.guilds

import com.sawako.backend.features.guilds.models.GuildReceiveRemote
import com.sawako.backend.features.guilds.models.mapToGuildResponseRemote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureGuildsRouting() {
    routing {
        get("/guilds/") {
            val guilds = GuildsController.getGuilds()
            call.respond(HttpStatusCode.OK, guilds)
        }

        get("/guilds/{id}") {
            val guild = call.receive<GuildReceiveRemote>()
            call.respond(
                HttpStatusCode.OK,
                GuildsController.getGuild(guild)
                    .mapToGuildResponseRemote()
            )
        }

        post("/guilds/create") {
            val guild = call.receive<GuildReceiveRemote>()
            GuildsController.createGuild(guild)
            call.respond(HttpStatusCode.OK)
        }

        post("/guilds/{id}/delete") {
            val guild = call.receive<GuildReceiveRemote>()
            GuildsController.deleteGuild(guild)
            call.respond(HttpStatusCode.OK, "Deleted successfully")
        }
    }
}
