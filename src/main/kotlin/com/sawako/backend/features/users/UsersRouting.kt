package com.sawako.backend.features.users

import com.sawako.backend.features.users.models.UserReceiveRemote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureUsersRouting() {
    routing {
        get("/users/") {
            call.respond(UsersController.getUsers())
        }

        get("/users/{id}") {
            val user = call.receive<UserReceiveRemote>()
            call.respond(
                HttpStatusCode.OK,
                UsersController.getUser(user)
            )
        }

        post("/users/create") {
            val user = call.receive<UserReceiveRemote>()
            UsersController.createUser(user)
            call.respond(HttpStatusCode.OK)
        }

        post("/users/{id}/delete") {
            val user = call.receive<UserReceiveRemote>()
            UsersController.deleteUser(user)
            call.respond(HttpStatusCode.OK, "Deleted successfully")
        }
    }
}

