package com.sawako.backend.view.users

import com.sawako.backend.view.users.controllers.create.createUser
import com.sawako.backend.view.users.controllers.create.remotes.CreateUser
import com.sawako.backend.view.users.controllers.delete.deleteUser
import com.sawako.backend.view.users.controllers.delete.remotes.DeleteUser
import com.sawako.backend.view.users.controllers.fetch.all.fetchUsers
import com.sawako.backend.view.users.controllers.fetch.all.remotes.FetchUsers
import com.sawako.backend.view.users.controllers.fetch.one.fetchUser
import com.sawako.backend.view.users.controllers.fetch.one.remotes.FetchUser
import io.ktor.server.resources.*
import io.ktor.server.routing.Routing

fun Routing.users() {
    post<CreateUser>(createUser)

    get<FetchUsers>(fetchUsers)

    get<FetchUser>(fetchUser)

    delete<DeleteUser>(deleteUser)
}
