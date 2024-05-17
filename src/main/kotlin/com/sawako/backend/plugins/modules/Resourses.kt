package com.sawako.backend.plugins.modules

import io.ktor.server.application.*
import io.ktor.server.resources.*

fun Application.resources() {
    install(Resources)
}