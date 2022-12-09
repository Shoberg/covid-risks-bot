package ru.spbstu

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.spbstu.bot.state.StateHandler
import ru.spbstu.user.UserBotState

@Configuration
class AppConfiguration {
    @Bean
    fun stateHandlersMap(@Autowired handlers: List<StateHandler>): Map<UserBotState, StateHandler>{
        return mutableMapOf<UserBotState, StateHandler>().apply {
            handlers.forEach { this[it.state] = it }
        }
    }
}