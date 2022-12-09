package ru.spbstu.user

import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.meta.api.objects.Message

enum class UserBotState {

    GREETING{
        override val next get() = START
        override val prev get() = GREETING
        override val message = "Hi! This is a bot for assessing the risk of infection covid-19\n" +
                "You should fill form with some questions\n\n" +
                "Print \"go\", to start"
    },

    START{
        override val next get() = AGE
        override val prev get() = GREETING
        override val message = "Your age (number from 1 to 100)"
    },

    AGE{
        override val next get() = GENDER
        override val prev get() = START
        override val message = "Your sex (male/female)"
    },

    GENDER{
        override val next get() = WAS_VACCINE
        override val prev get() = AGE
        override val message = "Have you been vaccinated?\n" +
                "Print the number from 1 to 6, where: \n" +
                "1. More than year ago\n" +
                "2. More than 6 month ago\n" +
                "3. More than 3 month ago\n" +
                "4. More than 1 month ago\n" +
                "5. Less than 6 month ago\n" +
                "6. Not vaccinated\n"
    },

//    WAS_ILL{
//        override val next get() = WAS_VACCINE
//        override val prev get() = GENDER
//        override val message = "Вакцинировались ли вы?\n" +
//                "Отправьте цифру от 1 до 6, где: \n" +
//                "1. Больше года назад\n" +
//                "2. Больше 6 месяцев назад\n" +
//                "3. Больше 3 месяцев назад\n" +
//                "4. Больше 1 месяца назад\n" +
//                "5. Меньше одного месяца назад\n" +
//                "6. Не вакцинировался\n"
//    },

    WAS_VACCINE{
        override val next get() = PLACES_FREQUENCY
        override val prev get() = GENDER
        override val message = "How often do you visit places where a large number of people gather?\n" +
                "Print the number from 1 to 10, where: \n" +
                "1 - almost not leaving home\n" +
                "10 - go somewhere everyday"
    },

    PLACES_FREQUENCY{
        override val next get() = MASK
        override val prev get() = WAS_VACCINE
        override val message = "Do you wearing a mask?\n" +
                "Print the number from 1 to 5, where: \n" +
                "1. Yes, always and everywhere\n" +
                "2. Usually wear\n" +
                "3. Wear mask only if asked\n" +
                "4. Usually do not wear\n" +
                "5. Do not wear, categorically against masks\n"
    },

    MASK{
        override val next get() = POPULATION
        override val prev get() = PLACES_FREQUENCY
        override val message = "What is the population of your city?\n" +
                "Print the number from 1 to 7, where: \n" +
                "1. More than 10 million\n" +
                "2. More than 5 million\n" +
                "3. More than 1 million\n" +
                "4. More than 500 thousand\n" +
                "5. More than 100 thousand\n" +
                "6. More than 10 thousand\n" +
                "7. Less than 10 thousand\n"
    },

    POPULATION{
        override val next get() = START
        override val prev get() = MASK
        override val message = "Nice, form was filled"
    };

//    GOT_RESULT {
//        override val next get() = START
//        override val prev get() = POPULATION
//        override val message = "Напишите \"go\", чтобы пройти опрос еще раз"
//    };

    abstract val next: UserBotState
    abstract val prev: UserBotState
    abstract val message: String

    fun ask(): Pair<String, UserBotState> = this.message to this.next
    fun wrongAnswer(): Pair<String, UserBotState> = this.prev.message to this
}
