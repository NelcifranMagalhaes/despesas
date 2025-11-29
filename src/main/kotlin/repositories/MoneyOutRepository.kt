package nyo.com.br.repositories

import nyo.com.br.database.dao.MoneyOutDao
import nyo.com.br.models.MoneyOut

class MoneyOutRepository(
    private val dao: MoneyOutDao = MoneyOutDao()
) {

    suspend fun moneyOuts() = dao.findAll()

    suspend fun save(moneyOut: MoneyOut) = dao.save(moneyOut)

    suspend fun update(moneyOut: MoneyOut) = dao.update(moneyOut)
}