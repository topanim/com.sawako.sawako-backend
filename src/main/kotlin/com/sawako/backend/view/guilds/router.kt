package com.sawako.backend.view.guilds

import com.sawako.backend.view.guilds.controllers.create.createGuild
import com.sawako.backend.view.guilds.controllers.create.remotes.CreateGuild
import com.sawako.backend.view.guilds.controllers.delete.deleteGuild
import com.sawako.backend.view.guilds.controllers.delete.remotes.DeleteGuild
import com.sawako.backend.view.guilds.controllers.fetch.all.fetchGuilds
import com.sawako.backend.view.guilds.controllers.fetch.all.remotes.FetchGuilds
import com.sawako.backend.view.guilds.controllers.fetch.one.fetchGuild
import com.sawako.backend.view.guilds.controllers.fetch.one.remotes.FetchGuild
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.routing.Routing

fun Routing.guilds() {
    post<CreateGuild>(createGuild)

    get<FetchGuilds>(fetchGuilds)

    get<FetchGuild>(fetchGuild)

    delete<DeleteGuild>(deleteGuild)
}

