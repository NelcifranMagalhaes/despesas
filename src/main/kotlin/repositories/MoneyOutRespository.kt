package nyo.com.br.repositories

import nyo.com.br.models.MoneyOut

class MoneyOutRespository {
    val moneyOuts get() = _moneyOuts.toList()

    fun save(moneyOut: MoneyOut) {
        _moneyOuts.add(moneyOut)
    }

    companion object {
        private val _moneyOuts = mutableListOf<MoneyOut>()
    }
}