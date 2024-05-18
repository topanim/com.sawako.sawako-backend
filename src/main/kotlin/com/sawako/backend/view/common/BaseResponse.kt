package com.sawako.backend.view.common

import com.sawako.backend.utils.serializers.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.time.LocalDateTime

@Serializable
open class BaseResponse(
    val meta: MetaResponse
)

@Serializable
class MetaResponse(
    var message: String,
    var status: Int = 200,

    @Serializable(with = LocalDateTimeSerializer::class)
    private val timestamp: LocalDateTime = LocalDateTime.now(),

    @Transient val builder: MetaResponse.() -> Unit = { }
) {
    init { apply(builder) }
}