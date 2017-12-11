package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    println("IsTrue= ${isTrue(4, 10)}")

    var number = getInt()
    println("Number= $number")

    number = increment(number)
    println("Number= $number")

    number = sum(number, 3)
    println("Number= $number")

    printSum(4, 5)
}

//private fun getInt() : Int{
//    return 10
//}

private fun getInt() = 10

//private fun isTrue() : Boolean {
//    return 4 < 10
//}

private fun isTrue(a: Int, b: Int) = a < b

private fun increment(number: Int) = number + 1

private fun sum(a: Int, b: Int) = a + b

private fun printSum(a: Int, b: Int) = println("$a + $b = ${a+b}")