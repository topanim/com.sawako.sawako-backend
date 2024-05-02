package com.sawako.backend.view.users.controllers.delete.remotes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserReceive(
    val id: Long
)