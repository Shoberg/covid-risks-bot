package ru.spbstu.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.bots.TelegramWebhookBot
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.generics.BotOptions
import org.telegram.telegrambots.meta.generics.LongPollingBot

@Service
class CovidBot(
    private val botFacade: CovidBotFacade,
    @Value("\${bot.token}")
    val token: String,
    @Value("\${bot.name}")
    val name: String
): TelegramLongPollingBot() {

//    override fun getBotToken(): String {
//        return token
//    }
//
//    override fun getBotUsername(): String {
//        return name
//    }

    //    override fun onWebhookUpdateReceived(p0: Update?): BotApiMethod<*>? {
//        return botFacade.onWebhookUpdateReceived(p0)
//    }
//
//    override fun getBotPath(): String {
//        return webHookPath
//    }
    override fun getBotToken(): String {
        return token;
    }

    override fun getBotUsername(): String {
        return name;
    }

    override fun onUpdateReceived(p0: Update?) {
        var method = botFacade.onWebhookUpdateReceived(p0);
        if(method != null)
            this.execute(method);
    }
}