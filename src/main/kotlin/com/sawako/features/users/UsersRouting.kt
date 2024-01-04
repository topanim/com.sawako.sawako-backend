package com.sawako.features.users

import com.sawako.features.users.models.UserReceiveRemote
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
            call.parameters["id"]?.toLong()?.let { it1 ->
                call.respond(HttpStatusCode.OK,
                    UsersController.getUser(
                        id = it1
                    )
                )
            }

            call.respond(HttpStatusCode.NotFound, "User not found")
        }

        post("/users/create") {
            val user = call.receive<UserReceiveRemote>()

            try {
                UsersController.createUser(user)
                call.respond(HttpStatusCode.Created, "Created successfully")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Creation Failed")
            }

        }

        post("/users/create/pack") {
            val users = call.receive<List<UserReceiveRemote>>()

            users.forEach {user ->
                try {
                    UsersController.createUser(user)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "Creation Failed")
                }
            }
            call.respond(HttpStatusCode.Created, "Created successfully")
        }
    }
}
