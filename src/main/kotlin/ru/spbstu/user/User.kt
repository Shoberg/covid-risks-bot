package ru.spbstu.user

class User(
    val id: Long,
    var state: UserBotState = UserBotState.GREETING,
    var answers: UserAnswers = UserAnswers()
)