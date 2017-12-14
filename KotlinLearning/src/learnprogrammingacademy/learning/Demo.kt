package learnprogrammingacademy.learning

class ComplexNumber(val real: Float, val imaginary: Float){

    operator fun plus(other: ComplexNumber) =
            ComplexNumber(real + other.real, imaginary + other.imaginary)

    override fun toString(): String {
        val sign = if(imaginary == 0f){
            ""
        }else if(imaginary >= 0){
            "+"
        }else{
            "-"
        }

        return "$real $sign ${Math.abs(imaginary)}i"
    }
}

fun main(args: Array<String>) {
    val first = ComplexNumber(2f, 2f)
    val second = ComplexNumber(3f, -5f)

    println("first= $first")
    println("second= $second")

    val sum = first + second
    println("sum= $sum")
}