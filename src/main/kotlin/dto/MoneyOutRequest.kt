package nyo.com.br.dto

import nyo.com.br.enums.CategoryOut
import nyo.com.br.models.MoneyOut

class MoneyOutRequest(
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryOut,
){
    fun toMoneyOut() = MoneyOut(description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}