package nyo.com.br

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nyo.com.br.dto.MoneyInRequest
import nyo.com.br.dto.toResponse
import nyo.com.br.repositories.MoneyInRepository

fun Application.configureRouting() {
    val repository = MoneyInRepository()
    routing {
        get("/moneyIn") {
            val response = repository.moneyIns().map {
                it.toResponse()
            }
            call.respond(response)
        }

        post("/moneyIn"){
            val request = call.receive<MoneyInRequest>()
            repository.save(request.toMoneyIn())?.let {
                call.respondText(
                    "Money has been added to the database",
                    status = HttpStatusCode.Created
                )
            } ?: call.respondText(
                "Money not created",
                status = HttpStatusCode.BadRequest
            )

        }
    }
}
