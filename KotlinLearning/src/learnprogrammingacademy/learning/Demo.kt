package learnprogrammingacademy.learning

object StringUtils {
    fun startsWithUpperCase(value: String?) : Boolean = !(value.isNullOrEmpty()) && value!![0].isUpperCase()
}

fun String?.startsWithUpperCase() : Boolean = !(this.isNullOrEmpty()) && this!![0].isUpperCase()

infix fun Int.multiplyBy(multiplier: Int) = this * multiplier

fun main(args: Array<String>) {
    val myString = "Kotlin"

    println("toLower=  ${myString.toLowerCase()}")
    println("startsWithUpperCase= ${StringUtils.startsWithUpperCase(myString)}")
    println("startsWithUpperCase= ${StringUtils.startsWithUpperCase(null)}")
    println("startsWithUpperCase= ${StringUtils.startsWithUpperCase("")}")
    println("startsWithUpperCase= ${StringUtils.startsWithUpperCase(myString.toLowerCase())}")

    println("startsWithUpperCase ext= ${myString.startsWithUpperCase()}")
    println("startsWithUpperCase ext= ${null.startsWithUpperCase()}")
    println("startsWithUpperCase ext= ${"".startsWithUpperCase()}")
    println("startsWithUpperCase ext= ${myString.toLowerCase().startsWithUpperCase()}")

    println("1*5 ext= ${1.multiplyBy(5)}")
    println("1*5 ext= ${1 multiplyBy 5}")
}