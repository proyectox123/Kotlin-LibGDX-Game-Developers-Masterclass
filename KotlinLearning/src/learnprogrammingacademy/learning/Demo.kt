package learnprogrammingacademy.learning


/*
Using knowledge from previous lesson, override minus and times operators in Complex Number class
Print to console results of minus and times operations
 */
class ComplexNumber(val real: Float, val imaginary: Float){

    operator fun minus(other: ComplexNumber) = ComplexNumber(real - other.real, imaginary - other.imaginary)

    operator fun plus(other: ComplexNumber) = ComplexNumber(real + other.real, imaginary + other.imaginary)

    //(a + bi) * (c + di) = (ac - bd) + (bc + ad)i
    operator fun times(other: ComplexNumber) = ComplexNumber(timesGetRealPart(other), timesGetImaginaryPart(other))

    override fun toString(): String {
        return "$real ${getSign()} ${Math.abs(imaginary)}i"
    }

    private fun timesGetRealPart(other: ComplexNumber) = (real * other.real) - (imaginary * other.imaginary)

    private fun timesGetImaginaryPart(other: ComplexNumber) = (imaginary * other.real) + (real * other.imaginary)

    private fun getSign() = if(imaginary >= 0){
        "+"
    }else{
        "-"
    }
}

fun main(args: Array<String>) {
    val first = ComplexNumber(2f, 2f)
    val second = ComplexNumber(3f, -5f)

    println("first= $first")
    println("second= $second")

    println("sum= ${first + second}")
    println("minus= ${first - second}")
    println("mul= ${first * second}")
}