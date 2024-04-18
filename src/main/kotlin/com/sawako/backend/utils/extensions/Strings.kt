package com.sawako.backend.utils.extensions

fun String.default(defaultValue: String): String {
    return if (this.isBlank() || this.isEmpty()) defaultValue else this
}
