package com.sawako.backend.view.users

import io.ktor.resources.*

@Resource("/users")
class RUsers {

    @Resource("{userId}")
    class One(
        val parent: RUsers = RUsers(),

        // params
        val userId: Long
    )
}
