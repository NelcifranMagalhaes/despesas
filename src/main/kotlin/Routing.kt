package nyo.com.br

import io.ktor.server.application.*
import io.ktor.server.routing.*
import nyo.com.br.routes.moneyInRoutes
import nyo.com.br.routes.moneyOutRoutes

fun Application.configureRouting() {
    routing {
        // MoneyIn routes
        moneyInRoutes()

        // MoneyOut routes
        moneyOutRoutes()
    }
}
