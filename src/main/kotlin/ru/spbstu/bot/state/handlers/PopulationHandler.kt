package ru.spbstu.bot.state.handlers

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.service.RisksService
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.POPULATION
import ru.spbstu.utils.isInt

@Component
class PopulationHandler(
    @Qualifier("risks")
    val risksService: RisksService
): StateHandler() {
    override val state = POPULATION

    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
        if(
            !validateAndSaveMessage(message, userAnswers)
        ) return state.wrongAnswer()

        val risk = risksService.calculateRisks(userAnswers)

        println(userAnswers.toString())

        return "Nice, from was filled\n\n" +
//            "Мы оцениваем ваш риск заразиться как число в диапазоне от 0 до 1\n" +
//            "Ваш риск: $risk\n\n" +
                "Your risk of infection covid-19: $risk%\n\n" +
            "Print \"go\", to fill form again" to state.next
    }
    override fun validateAndSaveMessage(
        message: String,
        userAnswers: UserAnswers
    ): Boolean {
        val low = 1
        val high = 7
        if(
            !message.isInt() ||
            message.toInt() < low
            || message.toInt() > high) return false
        return true.also { userAnswers.population = message.toInt() }
    }
}