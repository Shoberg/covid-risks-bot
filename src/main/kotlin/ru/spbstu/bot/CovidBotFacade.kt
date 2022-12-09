package ru.spbstu.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import ru.spbstu.bot.state.StateContext
import ru.spbstu.service.UserService
import ru.spbstu.user.User

@Service
class CovidBotFacade(
    val stateContext: StateContext,
    @Qualifier("user_service")
    val userService: UserService
) {
    fun onWebhookUpdateReceived(update: Update?): SendMessage? {
        if (
            update != null &&
            update.hasMessage()
        ) {
            return handleMessage(update.message) as SendMessage
        }
        return null
    }

    private fun handleMessage(message: Message): BotApiMethod<*>? {
        val id = message.chatId
        if(!userService.isUserExist(id)) userService.save(id)
        val user = userService.getUser(id)
        return stateContext.handleMessage(message, user)
    }
}