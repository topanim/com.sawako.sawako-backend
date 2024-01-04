package com.sawako.utils.extensions

fun String.default(defaultValue: String): String {
    return if (this.isBlank() || this.isEmpty()) defaultValue else this
}
