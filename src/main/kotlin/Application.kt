package nyo.com.br

import io.ktor.server.application.*
import nyo.com.br.database.DatabaseFactory

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    configureRouting()
}
