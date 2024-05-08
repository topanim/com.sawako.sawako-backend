package com.sawako.backend.view.guilds.controllers.delete.remotes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteGuildReceive(
    val id: Long
)