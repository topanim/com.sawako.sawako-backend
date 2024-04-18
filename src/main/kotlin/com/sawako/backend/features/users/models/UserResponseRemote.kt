package com.sawako.backend.features.users.models

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseRemote(
    val id: Long
)