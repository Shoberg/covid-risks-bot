package ru.spbstu.bot.state.handlers

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState
import ru.spbstu.user.UserBotState.*

@Component
class StartHandler: StateHandler() {
    override val state = START

    override fun validateAndSaveMessage(message: String, userAnswers: UserAnswers): Boolean {
        return message == "go"
    }
}