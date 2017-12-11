package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    /*
    Write 3 methods with name sum
    First method needs to sum 2 numbers
    First method needs to sum 3 numbers
    First method needs to sum 4 numbers
    Call all 3 methods and print result to console
    All parameters and return types can be int
     */
    val a = 1
    val b = 2
    val c = 3

    var sum = sum(a, b)
    println("Sum(a, b)= $sum")

    sum = sum(a, b, sum)
    println("Sum(a, b, c)= $sum")

    sum = sum(a, b, c, sum)
    println("Sum(a, b, c, d)= $sum}")
}

private fun sum(a: Int, b: Int) = a + b
private fun sum(a: Int, b: Int, c: Int) = a + b + c
private fun sum(a: Int, b: Int, c: Int, d:Int) = a + b + c + d