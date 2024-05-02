package com.sawako.backend.view.guilds

import com.sawako.backend.view.guilds.controllers.create.createGuild
import com.sawako.backend.view.guilds.controllers.delete.deleteGuild
import com.sawako.backend.view.guilds.controllers.fetch.all.fetchGuilds
import com.sawako.backend.view.guilds.controllers.fetch.one.fetchGuild
import io.ktor.server.routing.*

const val router = "/guilds"

fun Routing.guilds() {
    get("$router/", fetchGuilds)

    get("$router/{id}", fetchGuild)

    post("$router/create", createGuild)

    post("$router/{id}/delete", deleteGuild)
}

