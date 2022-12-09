package ru.spbstu.repo

import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState

interface UserDataRepo {
    fun getUser(id: Long): User
    fun getUserState(id: Long): UserBotState
    fun save(id: Long): User

    fun save(user: User): User

    fun isUserExist(id: Long): Boolean
}