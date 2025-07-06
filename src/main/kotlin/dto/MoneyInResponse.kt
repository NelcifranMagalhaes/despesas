package nyo.com.br.dto

import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryIn
import nyo.com.br.models.MoneyIn

@Serializable
class MoneyInResponse(
    val id: String,
    val description: String,
    val moneyValue: String,
    val createdAt: String,
    val category: CategoryIn,
)

fun MoneyIn.toResponse() = MoneyInResponse(
    id = id.toString(),
    description = description,
    moneyValue = moneyValue.toString(),
    createdAt = createdAt,
    category = category,
)