package learnprogrammingacademy.learning

var lives = 3
var score = 0
var coinCount = 90

val itemCount = 24
val itemsPerPage = 5

fun main(args: Array<String>) {
    println("Score= $score")

    score += 10
    println("Score= $score lives= $lives")

    lives--
    println("Score= $score lives= $lives")

    score *= 2
    println("Score= $score lives= $lives")

    score /= 2
    println("Score= $score lives= $lives")

    coinCount += 40
    println("Coin count= $coinCount")

    coinCount %= 100
    println("Coin count= $coinCount")

    val remainingItems = itemCount % itemsPerPage
    println("Remaining items= $remainingItems")
}