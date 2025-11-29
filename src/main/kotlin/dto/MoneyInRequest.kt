package nyo.com.br.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryIn
import nyo.com.br.models.MoneyIn
import java.util.UUID

@Serializable
class MoneyInRequest (
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryIn,
){
    fun toMoneyIn() = MoneyIn(description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}

@Serializable
class MoneyInUpdateRequest(
    @Contextual
    val id: UUID,
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryIn,
) {
    fun toMoneyIn() =
        MoneyIn(id= id,description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}