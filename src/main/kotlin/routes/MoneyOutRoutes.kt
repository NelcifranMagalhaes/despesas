package nyo.com.br.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nyo.com.br.dto.MoneyOutRequest
import nyo.com.br.dto.MoneyOutUpdateRequest
import nyo.com.br.dto.toResponse
import nyo.com.br.repositories.MoneyOutRepository
import java.util.UUID

fun Route.moneyOutRoutes(repository: MoneyOutRepository = MoneyOutRepository()) {

    get("/moneyOut") {
        val response = repository.moneyOuts().map {
            it.toResponse()
        }
        call.respond(response)
    }

    post("/moneyOut") {
        val request = call.receive<MoneyOutRequest>()
        repository.save(request.toMoneyOut())?.let {
            call.respondText(
                "Money has been added to the database",
                status = HttpStatusCode.Created
            )
        } ?: call.respondText(
            "Money not created",
            status = HttpStatusCode.BadRequest
        )
    }

    put("/moneyOut/{id}") {
        val idString = call.parameters["id"]?.toString() ?: throw IllegalArgumentException("ID inválido")
        val uuid = try {
            UUID.fromString(idString)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException()
        }

        val request = call.receive<MoneyOutUpdateRequest>()
        repository.update(request.toMoneyOut().copy(id = uuid))?.let {
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