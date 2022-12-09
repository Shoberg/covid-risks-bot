package ru.spbstu.service

//import jdk.internal.org.jline.utils.InputStreamReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.spbstu.user.UserAnswers
import ru.spbstu.utils.isDouble
import ru.spbstu.utils.isInt
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random


@Component("risks")
class RisksService(
    @Value("\${python-script-path}")
    val scriptPath: String
) {
    fun calculateRisks(answers: UserAnswers): Int{
        println("trying to start script")
        val cmd: Array<String> = arrayOf(
            "python3",
            scriptPath.toString(),
            answers.age.toString(),
            answers.gender.toString(),
            answers.wasVaccine.toString(),
            answers.placesFrequency.toString(),
            answers.mask.toString(),
            answers.population.toString()
        )

        val process = Runtime.getRuntime().exec(cmd)
        println("script started")

        val stdInput = BufferedReader(InputStreamReader(process.inputStream))
        val errInput = BufferedReader(InputStreamReader(process.errorStream))

        var result = 1.0

        println("trying read std output: ")
        try {
            var s: String = stdInput.readLine()
            while (s != null) {
                if(s.isDouble()) result = s.toDouble()
                println(s);
                s = stdInput.readLine()
            }
        }catch (e: Exception) {
            println("got exception")
        }

        println("trying read err output: ")
        try {
            var s: String = errInput.readLine()
            while (s != null) {
                println(s);
                s = errInput.readLine()
            }
        }catch (e: Exception) {
            println("got exception")
        }

        println("returning script result")
        return (result*100).toInt()
    }

}