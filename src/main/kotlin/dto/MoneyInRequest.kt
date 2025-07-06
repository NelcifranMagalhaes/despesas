package nyo.com.br.dto

import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryIn
import nyo.com.br.models.MoneyIn

@Serializable
class MoneyInRequest (
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryIn,
){
    fun toMoneyIn() = MoneyIn(description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}