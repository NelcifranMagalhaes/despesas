package nyo.com.br.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nyo.com.br.dto.MoneyInRequest
import nyo.com.br.dto.MoneyInUpdateRequest
import nyo.com.br.dto.toResponse
import nyo.com.br.repositories.MoneyInRepository
import java.util.UUID

fun Route.moneyInRoutes(repository: MoneyInRepository = MoneyInRepository()) {
    
    get("/moneyIn") {
        val response = repository.moneyIns().map {
            it.toResponse()
        }
        call.respond(response)
    }

    post("/moneyIn") {
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

    put("/moneyIn/{id}") {
        val idString = call.parameters["id"]?.toString() ?: throw IllegalArgumentException("ID inválido")
        val uuid = try {
            UUID.fromString(idString)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException()
        }

        val request = call.receive<MoneyInUpdateRequest>()
        repository.update(request.toMoneyIn().copy(id = uuid))?.let {
            call.respondText(
                "Money has been updated to the database",
                status = HttpStatusCode.Created
            )
        } ?: call.respondText(
            "Money not updated",
            status = HttpStatusCode.BadRequest
        )
    }
}

