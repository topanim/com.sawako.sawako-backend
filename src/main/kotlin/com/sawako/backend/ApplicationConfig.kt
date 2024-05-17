package com.sawako.backend

import java.io.FileInputStream
import java.util.*

object ApplicationConfig {
    private val properties = Properties().apply {
        load(FileInputStream("secrets.properties"))
    }

    val DB_USER: String = properties.getProperty("db.user")
    val DB_PASSWORD: String = properties.getProperty("db.password")
    val DB_PORT: Int = properties.getProperty("db.port").toInt()
    val DB_NAME: String = properties.getProperty("db.name")

}