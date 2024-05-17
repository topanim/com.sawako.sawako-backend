package com.sawako.backend.domain.guilds.settings.models

import com.sawako.backend.utils.serializers.LocalDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDateTime

@Serializable
data class DiscordEmbedAuthor(
    val name: String = "",
    val url: String = "",
    @SerialName("icon_url") val iconUrl: String = "",
)

@Serializable
data class DiscordEmbedThumbnail(
    val url: String = "",
)

@Serializable
data class DiscordEmbedFooter(
    val text: String = "",
    @SerialName("icon_url") val iconUrl: String = ""
)

@Serializable
data class DiscordEmbedField(
    val name: String = "",
    val value: String = "",
    val inline: Boolean = false,
)

@Serializable
data class DiscordEmbed(
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

@Serializable
data class SendEmbed(
    val flag: Boolean = false,
    val entity: DiscordEmbed = DiscordEmbed(),
)

@Serializable
data class AutoDelete(
    val flag: Boolean = false,
    val time: Int = 10
)

@Serializable
data class SendText(
    val flag: Boolean = false,
    val content: String = ""
)

@Serializable
data class Send(
    val flag: Boolean = false,
    @SerialName("auto_delete") val autoDelete: AutoDelete = AutoDelete(),
    val text: SendText = SendText(),
    val embed: SendEmbed = SendEmbed()
)

@Serializable
data class Ignore(
    val permissions: List<Int> = emptyList(),
    val roles: List<Long> = emptyList(),
    val channels: List<Long> = emptyList(),
)

@Serializable
data class Setting(
    val enabled: Boolean = false,
    val ignore: Ignore = Ignore(),
    val send: Send = Send(),
)

@Serializable
data class GuildSettings(
    @SerialName("auto_mod") val autoMod: Setting = Setting()
)