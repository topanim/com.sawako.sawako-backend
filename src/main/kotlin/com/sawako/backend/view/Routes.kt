package com.sawako.backend.view

import com.sawako.backend.view.guilds.guilds
import com.sawako.backend.view.members.members
import com.sawako.backend.view.users.users
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.routes() {
    routing {
        guilds()
        users()
        members()

// TODO: Create routes

//        get("/routes") {
//            val routes = this@routing.children
//            call.respondText(routes)
//        }
    }
}
