package nyo.com.br.dto

import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryOut
import nyo.com.br.models.MoneyOut

@Serializable
class MoneyOutResponse(
    val id: String,
    val description: String,
    val moneyValue: String,
    val createdAt: String,
    val category: CategoryOut,
)

fun MoneyOut.toResponse() = MoneyOutResponse(
    id = id.toString(),
    description = description,
    moneyValue = moneyValue.toString(),
    createdAt = createdAt,
    category = category,
)