package nyo.com.br.database

import nyo.com.br.models.MoneyIns
import nyo.com.br.models.MoneyOuts
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(driverClassName: String = "org.h2.Driver",
             jdbcUrl: String = "jdbc:h2:file:./build/db" )
    {
        val database = Database.connect(jdbcUrl, driverClassName)
        transaction(database) {
            SchemaUtils.create(MoneyIns)
            SchemaUtils.create(MoneyOuts)
        }
    }
}
