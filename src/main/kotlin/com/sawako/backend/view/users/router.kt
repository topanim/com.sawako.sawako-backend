package com.sawako.backend.view.users

import com.sawako.backend.view.users.controllers.create.createUser
import com.sawako.backend.view.users.controllers.delete.deleteUser
import com.sawako.backend.view.users.controllers.fetch.all.fetchUsers
import com.sawako.backend.view.users.controllers.fetch.one.fetchUser
import io.ktor.server.routing.*

const val router = "/users"

fun Routing.users() {
    get("$router/",  fetchUsers)

    get("$router/{id}", fetchUser)

    post("$router/create", createUser)

    delete("$router/{id}/delete", deleteUser)
}
