package com.sawako.backend.view.users.controllers.create.remotes

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserReceive(
    val id: Long
)