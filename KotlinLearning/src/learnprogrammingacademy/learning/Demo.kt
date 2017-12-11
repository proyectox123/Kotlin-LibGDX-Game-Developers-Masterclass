package learnprogrammingacademy.learning

var lives = 3
var playerName = "John"
var gameOver = false

val levelCount = 4

fun main(args: Array<String>) {
    printLivesLeft()

    lives += 2
    playerName += " " + "Smith"

    printLivesLeft()
    println("gameOver = $gameOver")

    println("PlayerName $playerName needs to comple $levelCount leels")
    gameOver = true
    println("gameOver = $gameOver")
}

private fun printLivesLeft(){
    println("Player $playerName has $lives lives left")
}