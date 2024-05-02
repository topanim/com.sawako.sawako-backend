package com.sawako.backend.view.users.controllers.fetch.all.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchUsersReceive(
    val page: Int,
    val size: Int
)