package ru.spbstu.bot.state

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import ru.spbstu.user.User
import ru.spbstu.user.UserBotState

@Service
class StateContext(
    val stateHandlersMap: Map<UserBotState, StateHandler>
){
    fun handleMessage(message: Message, user: User): BotApiMethod<*>? {
        return stateHandlersMap[user.state]?.handleMessage(message, user) ?:
            throw IllegalStateException("Have not handler for state: ${user.state}")
    }
}