package ru.spbstu.user

class UserAnswers {
    var age: Int? = null
    var gender: Int? = null
    var wasVaccine: Int? = null
    var placesFrequency: Int? = null
    var mask: Int? = null
    var population: Int? = null
    override fun toString(): String {
        return "UserAnswers(" +
                "\nage=$age, " +
                "\ngender=$gender, " +
                "\nwasVaccine=$wasVaccine, " +
                "\nplacesFrequency=$placesFrequency, " +
                "\nmask=$mask, " +
                "\npopulation=$population" +
                "\n)"
    }
}