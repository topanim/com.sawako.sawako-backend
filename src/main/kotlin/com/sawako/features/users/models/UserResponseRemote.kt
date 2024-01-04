package com.sawako.features.users.models

import io.netty.handler.logging.LogLevel
import kotlinx.serialization.Serializable

@Serializable
data class UserResponseRemote(
    val id: Long
)