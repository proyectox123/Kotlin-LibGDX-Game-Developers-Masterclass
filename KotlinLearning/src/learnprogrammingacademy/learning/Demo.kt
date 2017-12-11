package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    /*
    Use any loop from previous videos (for, while, do-while)
    sum all number from 1-100
    print sum to console
     */
    printWithFor()
    printWithSum()
    printWithWhile()
    printWithDoWhile()
}

@Suppress("LoopToCallChain")
private fun printWithFor(){
    var sum = 0
    for(i in 1..100){
        sum += i
    }

    println("printWithFor sum= $sum")
}

private fun printWithSum(){
    val sum = (1..100).sum()
    println("printWithSum sum= $sum")
}

private fun printWithWhile(){
    var sum = 0
    var index = 100
    while (index > 0){
        sum += index
        index--
    }

    println("printWithWhile sum= $sum")
}

private fun printWithDoWhile(){
    var sum = 0
    var index = 1
    do{
        sum += index
        index++
    }while (index <= 100)

    println("printWithDoWhile sum= $sum")
}