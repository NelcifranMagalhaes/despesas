package nyo.com.br.models
import nyo.com.br.enums.CategoryIn
import org.jetbrains.exposed.sql.Table
import java.util.UUID

data class MoneyIn(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val moneyValue: Float,
    val createdAt: String,
    val category: CategoryIn,
)

object MoneyIns : Table() {
    val id = uuid("id").autoGenerate()
    val description = text("description")
    val moneyValue = float("money_value")
    val createdAt = text("created_at")
    val category = enumeration<CategoryIn>("category")
    override val primaryKey = PrimaryKey(id)
}