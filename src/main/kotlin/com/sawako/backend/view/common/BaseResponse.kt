package com.sawako.backend.view.common

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse(
    val meta: MetaResponse
)

@Serializable
class MetaResponse(
    val message: String
)