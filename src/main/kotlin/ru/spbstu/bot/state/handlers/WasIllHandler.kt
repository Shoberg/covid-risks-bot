package ru.spbstu.bot.state.handlers

//import org.springframework.stereotype.Component
//import ru.spbstu.bot.state.StateHandler
//import ru.spbstu.user.UserAnswers
//import ru.spbstu.user.UserBotState
//import ru.spbstu.user.UserBotState.*
//import ru.spbstu.utils.isInt
//
//@Component
//class WasIllHandler: StateHandler() {
//    override val state = WAS_ILL
//
//    override fun validateAndSaveMessage(
//        message: String,
//        userAnswers: UserAnswers
//    ): Boolean {
//        val low = 0
//        val high = 10
//        if(
//            !message.isInt() ||
//            message.toInt() < low
//            || message.toInt() > high) return false
//        return true.also { userAnswers.wasIll = message.toInt() }
//    }
//}