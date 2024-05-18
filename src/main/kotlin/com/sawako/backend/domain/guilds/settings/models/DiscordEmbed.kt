package com.sawako.backend.domain.guilds.settings.models

import com.sawako.backend.utils.serializers.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class DiscordEmbed(
    val title: String = "",
    val description: String = "",
    val color: Int = 0xFFFFFF,
    val author: DiscordEmbedAuthor = DiscordEmbedAuthor(),
    val thumbnail: DiscordEmbedThumbnail = DiscordEmbedThumbnail(),
    val fields: List<DiscordEmbedField> = emptyList(),
    val image: String = "",
    val footer: DiscordEmbedFooter = DiscordEmbedFooter(),

    @Serializable(with = LocalDateTimeSerializer::class)
    val datetime: LocalDateTime = LocalDateTime.now()
)