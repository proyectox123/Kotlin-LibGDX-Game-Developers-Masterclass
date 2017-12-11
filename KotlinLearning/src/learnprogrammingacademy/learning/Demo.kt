package learnprogrammingacademy.learning

var lives = 3
var score = 0
var coinCount = 110
var gameOver = false

fun main(args: Array<String>) {
    score += 10
    coinCount = 110 //Re-initializing
    //lives = 0

    if(lives == 0){
        gameOver = true
    }

    printMedal()

    if(gameOver){
       println("score= $score")
    }else{
        println("lives= $lives")
    }

    if(!gameOver){
        println("Game is not over")
    }

    val max = getMax(5, 8)
    println("Max= $max")
}

private fun printMedal(){
    if(coinCount > 100){
        println("Gold medal!")
    } else if(coinCount > 80){
        println("Silver medal!")
    } else if(coinCount > 70){
        println("Bronze medal!")
    } else {
        println("No medal...")
    }
}

private fun getMax(a: Int, b: Int) = if(a > b) a else b