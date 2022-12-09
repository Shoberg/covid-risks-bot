package ru.spbstu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CovidBotApplication

fun main(args: Array<String>) {
	runApplication<CovidBotApplication>(*args)
}
