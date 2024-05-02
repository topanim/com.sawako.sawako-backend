package com.sawako.backend.view.users.controllers.fetch.one.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchUserReceive(
    val id: Long
)