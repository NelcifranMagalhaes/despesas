package nyo.com.br.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryOut
import nyo.com.br.models.MoneyOut
import java.util.UUID

@Serializable
class MoneyOutRequest(
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryOut,
){
    fun toMoneyOut() = MoneyOut(description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}

@Serializable
class MoneyOutUpdateRequest(
    @Contextual
    val id: UUID,
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryOut,
) {
    fun toMoneyOut() =
        MoneyOut(id = id, description = description, category = category, moneyValue = moneyValue, createdAt = createdAt)
}