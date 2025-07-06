package nyo.com.br.models

import kotlinx.serialization.Serializable
import nyo.com.br.enums.CategoryOut
import org.jetbrains.exposed.sql.Table
import java.util.UUID

data class MoneyOut(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryOut,
)

object MoneyOuts : Table() {
    val id = uuid("id").autoGenerate()
    val description = text("description")
    val moneyValue = float("money_value")
    val createdAt = text("created_at")
    val category = text("category")
    override val primaryKey = PrimaryKey(MoneyIns.id)
}

