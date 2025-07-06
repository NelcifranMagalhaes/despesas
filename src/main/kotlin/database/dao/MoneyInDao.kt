package nyo.com.br.database.dao

import kotlinx.coroutines.Dispatchers
import nyo.com.br.models.MoneyIn
import nyo.com.br.models.MoneyIns
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class MoneyInDao {
    suspend fun findAll(): List<MoneyIn> = dbQuery {
        MoneyIns.selectAll().map {
            MoneyIn(
                id = it[MoneyIns.id],
                description = it[MoneyIns.description],
                moneyValue = it[MoneyIns.moneyValue],
                createdAt = it[MoneyIns.createdAt],
                category = it[MoneyIns.category]
            )
        }
    }

    suspend fun save(moneyIn: MoneyIn) = dbQuery {
        val insertStatement = MoneyIns.insert {
            it[id] = moneyIn.id
            it[description] = moneyIn.description
            it[moneyValue] = moneyIn.moneyValue
            it[createdAt] = moneyIn.createdAt
            it[category] = moneyIn.category
        }
        insertStatement.resultedValues?.singleOrNull()?.let {
            MoneyIn(
                id = it[MoneyIns.id],
                description = it[MoneyIns.description],
                moneyValue = it[MoneyIns.moneyValue],
                createdAt = it[MoneyIns.createdAt],
                category = it[MoneyIns.category]
            )
        }
    }
}

suspend fun <T> dbQuery(block: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { block() }