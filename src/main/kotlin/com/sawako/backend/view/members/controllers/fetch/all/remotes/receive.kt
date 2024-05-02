package com.sawako.backend.view.members.controllers.fetch.all.remotes

import kotlinx.serialization.Serializable

@Serializable
data class FetchAllMembersReceive(
    val page: Int,
    val size: Int
)