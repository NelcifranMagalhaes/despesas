package nyo.com.br.database.dao

import kotlinx.coroutines.Dispatchers
import nyo.com.br.enums.CategoryOut
import nyo.com.br.models.MoneyOut
import nyo.com.br.models.MoneyOuts
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class MoneyOutDao {
    suspend fun findAll(): List<MoneyOut> = dbQuery {
        MoneyOuts.selectAll().map {
            MoneyOut(
                id = it[MoneyOuts.id],
                description = it[MoneyOuts.description],
                moneyValue = it[MoneyOuts.moneyValue],
                createdAt = it[MoneyOuts.createdAt],
                category = CategoryOut.valueOf(it[MoneyOuts.category])
            )
        }
    }

    suspend fun save(moneyOut: MoneyOut) = dbQuery {
        val insertStatement = MoneyOuts.insert {
            it[id] = moneyOut.id
            it[description] = moneyOut.description
            it[moneyValue] = moneyOut.moneyValue
            it[createdAt] = moneyOut.createdAt
            it[category] = moneyOut.category.name
        }
        insertStatement.resultedValues?.singleOrNull()?.let {
            MoneyOut(
                id = it[MoneyOuts.id],
                description = it[MoneyOuts.description],
                moneyValue = it[MoneyOuts.moneyValue],
                createdAt = it[MoneyOuts.createdAt],
                category = CategoryOut.valueOf(it[MoneyOuts.category])
            )
        }
    }

    suspend fun update(moneyOut: MoneyOut) = dbQuery {
        MoneyOuts.update({ MoneyOuts.id eq moneyOut.id }) {
            it[description] = moneyOut.description
            it[moneyValue] = moneyOut.moneyValue
            it[createdAt] = moneyOut.createdAt
            it[category] = moneyOut.category.name
        }
    }
}