package com.sawako.backend.view.common

import com.sawako.backend.utils.serializers.LocalDateTimeSerializer
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
open class BaseResponse(
    val meta: MetaResponse
)

@Serializable
class MetaResponse(
    val message: String,
    @Serializable(with = LocalDateTimeSerializer::class) private val timestamp: LocalDateTime = LocalDateTime.now()
)