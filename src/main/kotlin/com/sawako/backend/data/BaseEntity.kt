package com.sawako.backend.data

import com.sawako.backend.data.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

abstract class BaseEntity(name: String) : Table(name) {
    val id: Column<Long> = long("id").autoIncrement()

    override val primaryKey = PrimaryKey(id, name = "PK_${name}_ID")

    suspend fun all(
        limit: Int,
        offset: Long,
        where: SqlExpressionBuilder.() -> Op<Boolean>,
    ) = dbQuery {
        select(where).limit(limit ?: Int.MAX_VALUE, offset).toList()
    }

    suspend fun many(_ids: List<Long>) = dbQuery {
        select { id inList _ids }.toList()
    }

    suspend fun one(_id: Long) = dbQuery {
        select { id eq _id }.single()
    }

    suspend fun delete(_id: Long): Unit = dbQuery {
        deleteWhere { id eq _id }
    }
}
