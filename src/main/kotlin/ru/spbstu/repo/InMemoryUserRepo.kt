package ru.spbstu.repo

import org.springframework.stereotype.Repository
import ru.spbstu.user.User
import ru.spbstu.user.UserAnswers
import ru.spbstu.user.UserBotState

@Repository
class InMemoryUserRepo: UserDataRepo {

    val usersList: MutableList<User> = mutableListOf()
    override fun getUser(id: Long): User {
        if (usersList.none { it.id == id })
            throw IllegalArgumentException("No such user with id: $id")
        return usersList.first { it.id == id }
    }

    override fun getUserState(id: Long): UserBotState {
        return getUser(id).state
    }

    override fun save(id: Long): User {
        if(usersList.any { it.id == id })
            throw IllegalStateException("already have this user in base with id: $id")
        return User(id = id).also { usersList.add(it) }
    }

    override fun save(user: User): User {
        if(usersList.any { it.id == user.id }){
            usersList.first{it.id == user.id}.apply {
                this.answers = user.answers
                this.state = user.state
            }
        }
        else{

        }
        return user
    }

    override fun isUserExist(id: Long): Boolean {
        return usersList.any{ it.id == id }
    }

}