package com.sawako.backend.database.guilds.models

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDateTime

data class DiscordEmbedAuthor(
    val name: String = "",
    val url: String = "",
    val iconUrl: String = "",
)

data class DiscordEmbedThumbnail(
    val url: String = "",
)

data class DiscordEmbedFooter(
    val text: String = "",
    val iconUrl: String = ""
)

data class DiscordEmbedField(
    val name: String = "",
    val value: String = "",
    val inline: Boolean = false,
)

data class DiscordEmbed(
    val title: String = "",
    val description: String = "",
    val color: Int = 0xFFFFFF,
    val author: DiscordEmbedAuthor = DiscordEmbedAuthor(),
    val datetime: LocalDateTime = LocalDateTime.now(),
    val thumbnail: DiscordEmbedThumbnail = DiscordEmbedThumbnail(),
    val fields: List<DiscordEmbedField> = emptyList(),
    val image: String = "",
    val footer: DiscordEmbedFooter = DiscordEmbedFooter()
)

data class SendEmbed(
    val flag: Boolean = false,
    val entity: DiscordEmbed = DiscordEmbed(),
)

data class AutoDelete(
    val flag: Boolean = false,
    val time: Int = 10
)

data class SendText(
    val flag: Boolean = false,
    val content: String = ""
)

data class Send(
    val flag: Boolean = false,
    val autoDelete: AutoDelete = AutoDelete(),
    val text: SendText = SendText(),
    val embed: SendEmbed = SendEmbed()
)

data class Ignore(
    val permissions: List<Int> = emptyList(),
    val roles: List<Long> = emptyList(),
    val channels: List<Long> = emptyList(),
)

data class Setting(
    val enabled: Boolean = false,
    val ignore: Ignore = Ignore(),
    val send: Send = Send(),
)

fun main() {
    println(Json.encodeToString(Setting()))
}