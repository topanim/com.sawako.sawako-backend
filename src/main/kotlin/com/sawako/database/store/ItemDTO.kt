package com.sawako.database.store

import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
    val guildId: Long,

    val id: Long,
    val name: String,
    val description: String,
    val type: Short,
    val price: Int
)