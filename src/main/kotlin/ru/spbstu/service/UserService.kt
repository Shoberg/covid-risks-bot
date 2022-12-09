package ru.spbstu.service

import org.jvnet.hk2.annotations.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.spbstu.repo.UserDataRepo
import ru.spbstu.user.UserBotState
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers

@Component("user_service")
class UserService(
    private val userRepo: UserDataRepo
){
    fun getUser(id: Long): User {
        return userRepo.getUser(id)
    }
    fun getUserState(id: Long): UserBotState{
        return userRepo.getUserState(id)
    }
    fun save(id: Long): User{
        return userRepo.save(id)
    }

    fun isUserExist(id: Long): Boolean{
        return userRepo.isUserExist(id)
    }
}