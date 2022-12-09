package ru.spbstu.bot.state.handlers
//
//import org.springframework.stereotype.Component
//import ru.spbstu.bot.state.StateHandler
//import ru.spbstu.user.UserAnswers
//import ru.spbstu.user.UserBotState
//import ru.spbstu.user.UserBotState.GOT_RESULT

//@Component
//class GotResultHandler: StateHandler() {
//    override val state = GOT_RESULT
//
//    override fun validateAndSaveMessage(message: String, userAnswers: UserAnswers): Boolean {
//        return super.validateAndSaveMessage(message, userAnswers)
//    }
//
//    override fun handleMessage(message: String, userAnswers: UserAnswers): Pair<String, UserBotState> {
//        return super.handleMessage(message, userAnswers)
//    }
//}