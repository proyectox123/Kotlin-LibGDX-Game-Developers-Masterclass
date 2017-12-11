package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    /*
    Create array of strings that represents names of people
    Print all string names that start with capital letter T in uppercase
    Find method in String class that checks if staring startsWith another string
     */

    //val names = arrayOf("Tania", "Ximena", "Tadeo", "Víctor", "Marcos")
    val names = arrayOf("John", "Tom", "Anthony", "Jimmy", "Timmy")
    printNames(names)
}

private fun printNames(names: Array<String>) {
    names.asSequence()
            .filter { it.startsWith("T") }
            .forEach { println("Name= ${it.toUpperCase()}") }
}