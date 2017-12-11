package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    var result = subtract(5, 1)
    println("Subtract(5, 1)= $result")

    result = subtract(5, 2,1)
    println("Subtract(5, 2, 1)= $result")

    result = mul(2, 4)
    println("Mul(2, 4)= $result")

    val floatResult = mul(2.5f, 3.5f)
    println("Mul(2.5f, 3.5f)= $floatResult")
}

private fun subtract(a: Int, b: Int) = a - b

private fun subtract(a: Int, b: Int, c: Int) = a - b - c

private fun mul(a: Int, b: Int) = a* b

private fun mul(a: Float, b: Float) = a* b