package learnprogrammingacademy.learning

/*
Write extension method that will return true if string has even number of characters or false if string has odd number of characters
Test method in main with few different strings
Write method in StringUtils that will calculate sum of two strings lengths, or in other words sum of characters in 2 strings
Tip: Use modulus operator for even odd testing
Tip: Be careful with null values and empty strings
 */

fun String?.hasEvenNumberOfCharacters() = this != null && this.length % 2 == 0

object StringUtils {
    fun sumStringsLengths(param1: String?, param2: String?) = getStringLength(param1) + getStringLength(param2)

    private fun getStringLength(param: String?) = if(param.isNullOrBlank()){
        0
    }else{
        param!!.length
    }
}

fun main(args: Array<String>) {
    println("hasEvenNumberOfCharacters= ${null.hasEvenNumberOfCharacters()}")
    println("hasEvenNumberOfCharacters= ${"".hasEvenNumberOfCharacters()}")
    println("hasEvenNumberOfCharacters= ${"Kotlin".hasEvenNumberOfCharacters()}")
    println("hasEvenNumberOfCharacters= ${"Kotlin1".hasEvenNumberOfCharacters()}")

    println("sumStringsLengths= ${StringUtils.sumStringsLengths(null, null)}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths(null, "")}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths(null, "World!")}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths("", null)}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths("", "World!")}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths("Hello", null)}")
    println("sumStringsLengths= ${StringUtils.sumStringsLengths("Hello", "World!")}")
}