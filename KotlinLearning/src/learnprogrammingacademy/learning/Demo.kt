package learnprogrammingacademy.learning

var lives = 3
var coinCount = 90

fun main(args: Array<String>) {
    whileFunction()
    lives = 3
    doWhileFunction()
}

private fun whileFunction(){
    while (lives > 0) {
        println("lives= $lives")
        lives--
    }
}

private fun doWhileFunction(){
    do {
        coinCount += 20
        lives--
    }while (lives > 0)

    println("coins= $coinCount lives= $lives")
}