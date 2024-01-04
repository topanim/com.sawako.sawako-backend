package com.sawako.database.store

import com.sawako.database.guilds.Guilds
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Store : Table("store") {
    private val itemId: Column<Long> = long("id").autoIncrement()
    private val name: Column<String> = varchar("name",10)
    private val description: Column<String> = varchar("description",10)
    private val type: Column<Short> = short("type")
    private val price: Column<Int> = integer("price")

    private val guildId: Column<Long> = reference("guild_id", Guilds.guildId)

    override val primaryKey = PrimaryKey(itemId, name = "PK_Store_ID")

    fun insert(itemDTO: ItemDTO) {
        transaction {
            Store.insert {
                it[itemId] = itemDTO.id
            }
        }
    }

    fun fetchOne(id: Long): ItemDTO {
        return transaction {
            val item = Store.select { itemId eq id }.single()

            ItemDTO(
                id = item[itemId],
                name = item[name],
                description = item[description],
                type = item[type],
                price = item[price],
                guildId = item[guildId]
            )
        }
    }

    fun fetchAll(): List<ItemDTO> {
        return try {
            transaction {
                Store.selectAll().toList()
                    .map {
                        ItemDTO(
                            id = it[itemId],
                            name = it[name],
                            description = it[description],
                            type = it[type],
                            price = it[price],
                            guildId = it[guildId]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}