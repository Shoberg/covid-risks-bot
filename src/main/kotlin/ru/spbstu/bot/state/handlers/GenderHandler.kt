package ru.spbstu.bot.state.handlers

import org.springframework.stereotype.Component
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*

@Component
class GenderHandler: StateHandler() {
    override val state = GENDER

    override fun validateAndSaveMessage(message: String, userAnswers: UserAnswers): Boolean {
        if (message !in listOf("male", "female")) return false
        if(message == "male") userAnswers.gender = 0
        else userAnswers.gender = 1
        return true
    }
}