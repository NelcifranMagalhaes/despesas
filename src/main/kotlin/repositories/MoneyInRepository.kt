package nyo.com.br.repositories

import nyo.com.br.database.dao.MoneyInDao
import nyo.com.br.models.MoneyIn

class MoneyInRepository(
    private val dao: MoneyInDao = MoneyInDao()
) {

    suspend fun moneyIns() = dao.findAll()

    suspend fun save(moneyIn: MoneyIn) = dao.save(moneyIn)
}