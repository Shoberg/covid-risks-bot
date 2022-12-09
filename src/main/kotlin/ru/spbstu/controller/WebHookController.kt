package ru.spbstu.controller

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update
import ru.spbstu.bot.CovidBot


@RestController
class WebHookController(
    private val bot: CovidBot
) {
//    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
//    fun onUpdateReceived(@RequestBody update: Update?): BotApiMethod<*>? {
//        return bot.onWebhookUpdateReceived(update)
//    }
}