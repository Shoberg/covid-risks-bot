package ru.spbstu.bot.state.handlers

import org.springframework.stereotype.Component
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.WAS_VACCINE
import ru.spbstu.utils.isInt

@Component
class WasVaccineHandler: StateHandler() {
    override val state = WAS_VACCINE

    override fun validateAndSaveMessage(
        message: String,
        userAnswers: UserAnswers
    ): Boolean {
        val low = 1
        val high = 6
        if(
            !message.isInt() ||
            message.toInt() < low
            || message.toInt() > high) return false
        return true.also { userAnswers.wasVaccine = message.toInt() }
    }
}