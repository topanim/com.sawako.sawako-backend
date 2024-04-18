package com.sawako.backend.database.members

import com.sawako.backend.database.DatabaseFactory.dbQuery
import com.sawako.backend.database.members.Members.A
import com.sawako.backend.database.members.Members.B
import com.sawako.backend.database.members.Members.exp
import com.sawako.backend.database.members.Members.guildId
import com.sawako.backend.database.members.Members.lover
import com.sawako.backend.database.members.Members.lvl
import com.sawako.backend.database.members.Members.memberId
import com.sawako.backend.database.members.Members.userId
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.plus
import kotlin.math.pow

object MembersDAO {
    suspend fun insert(guildID: Long, userID: Long) = dbQuery {
        Members.insert {
            it[guildId] = guildID
            it[userId] = userID
            it[upExp] = calculateUpExp(1)
        }
    }

    suspend fun updateWallet(guildID: Long, userID: Long, amount: Int) = dbQuery {
        Members.update({
            (guildId eq guildID) and (userId eq userID)
        }) { it[wallet] = wallet + amount }
    }

    private fun calculateUpExp(lvl: Int): Int {
        return (A * lvl.toDouble().pow(B)).toInt()
    }

    private fun calculateLvl(exp: Int): com.sawako.backend.database.members.NewActivity {
        var lvl = 1
        while (true) {
            val upExp = calculateUpExp(lvl)
            if (upExp > exp) {
                return com.sawako.backend.database.members.NewActivity(lvl - 1, upExp)
            }
            lvl++
        }
    }

    suspend fun updateExp(
        guildID: Long,
        userID: Long,
        quantity: Int
    ): com.sawako.backend.database.members.MemberDTO = dbQuery {
        val before = Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()
            .mapToMemberDTO()

        Members.update({
            (guildId eq guildID) and (userId eq userID)
        }) {
            (before.exp + quantity).let { newExp ->
                it[exp] = newExp
                calculateLvl(newExp).let { newActivity ->
                    it[lvl] = newActivity.lvl
                    it[upExp] = newActivity.upExp
                }
            }
        }

        return@dbQuery Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()
            .mapToMemberDTO()
    }

    suspend fun updateBio(
        guildID: Long,
        userID: Long,
        cName: String? = null,
        cBirthdate: String? = null,
        cGender: String? = null,
        cAbout: String? = null
    ): com.sawako.backend.database.members.MemberDTO = dbQuery {
        Members.update({
            (guildId eq guildID) and (userId eq userID)
        }) {
            cName?.let { value -> it[name] = value }
            cBirthdate?.let { value -> it[birthdate] = value }
            cGender?.let { value -> it[gender] = value }
            cAbout?.let { value -> it[about] = value }
        }

        return@dbQuery Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()
            .mapToMemberDTO()
    }

    suspend fun resetBio(guildID: Long, userID: Long): com.sawako.backend.database.members.MemberDTO = dbQuery {

        Members.update({
            (guildId eq guildID) and (userId eq userID)
        }) {
            it[name] = ""
            it[birthdate] = ""
            it[gender] = ""
            it[about] = ""
        }

        return@dbQuery Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()
            .mapToMemberDTO()
    }

    suspend fun marry(
        firstGuildId: Long,
        firstUserId: Long,
        secondGuildId: Long,
        secondUserId: Long
    ): Unit = dbQuery {
        val first = Members
            .select { (guildId eq firstGuildId) and (userId eq firstUserId) }
            .single()

        val second = Members
            .select { (guildId eq secondGuildId) and (userId eq secondUserId) }
            .single()

        Members.update({ guildId eq first[memberId] }) { it[lover] = second[memberId] }
        Members.update({ memberId eq second[memberId] }) { it[lover] = first[memberId] }

    }

    suspend fun divorce(guildID: Long, userID: Long): Unit = dbQuery {
        val member = Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()

        member[lover]?.let {
            Members.update({
                (memberId eq member[memberId])
                (memberId eq it)
            }) { it[lover] = null }
        }
    }

    suspend fun fetchOne(memberID: Long): com.sawako.backend.database.members.MemberDTO = dbQuery {
        return@dbQuery Members
            .select { memberId eq memberID }
            .single()
            .mapToMemberDTO()
    }


    suspend fun fetchOne(guildID: Long, userID: Long): com.sawako.backend.database.members.MemberDTO = dbQuery {
        return@dbQuery Members
            .select { (guildId eq guildID) and (userId eq userID) }
            .single()
            .mapToMemberDTO()
    }


    suspend fun fetchAll(): List<com.sawako.backend.database.members.MemberDTO> = dbQuery {
        return@dbQuery Members
            .selectAll()
            .map { it.mapToMemberDTO() }
    }

    suspend fun fetchGuildTop(guildID: Long): List<com.sawako.backend.database.members.MemberDTO> = dbQuery {
        return@dbQuery Members
            .select { guildId eq guildID }
            .orderBy(lvl to SortOrder.DESC)
            .orderBy(exp to SortOrder.DESC)
            .map { it.mapToMemberDTO() }

    }

    suspend fun fetchGuildMembers(guildID: Long) = dbQuery {
        return@dbQuery Members
            .select { guildId eq guildID }
            .map { it.mapToMemberDTO() }
    }


    suspend fun delete(id: Long) = dbQuery {
        val member = Members.select { memberId eq id }.single()
        member[lover]?.let {
            Members.update({
                memberId eq member[memberId]
            }) { it[lover] = null }
        }

        Members.deleteWhere { memberId eq id }
    }


    suspend fun deleteGuildMembers(id: Long) = dbQuery {
        Members.deleteWhere { guildId eq id }
    }
}