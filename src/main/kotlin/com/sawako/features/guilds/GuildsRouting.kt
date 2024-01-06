package com.sawako.features.guilds

import com.sawako.database.guilds.mapToGuildResponseRemote
import com.sawako.features.guilds.models.GuildReceiveRemote
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
            call.parameters["id"]?.toLong()?.let {
                call.respond(HttpStatusCode.OK,
                    GuildsController.getGuild(
                        id = it
                    ).mapToGuildResponseRemote()
                )
            }

            call.respond(HttpStatusCode.NotFound, "Guild not found")
        }

        post("/guilds/create") {
            val guild = call.receive<GuildReceiveRemote>()

            try {
                GuildsController.createGuild(guild)
                call.respond(HttpStatusCode.Created, "Created successfully")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Creation Failed")
            }

        }

        post("/guilds/{id}/delete") {
            call.parameters["id"]?.toLong()?.let {
                try {
                    GuildsController.deleteGuild(it)
                    call.respond(HttpStatusCode.OK, "Deleted successfully")
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "Deletion failed")
                }
            }
        }
    }
}
