package com.sawako.backend.view.guilds.controllers.create.remotes

import kotlinx.serialization.Serializable

@Serializable
data class CreateGuildReceive(
    val id: Long
)