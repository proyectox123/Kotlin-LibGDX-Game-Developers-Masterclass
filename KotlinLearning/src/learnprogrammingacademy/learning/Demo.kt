package learnprogrammingacademy.learning

var names = IntArray(4)
var pets = arrayOf("Parrot", "Cat", "Dog")
var table = Array(3){
    IntArray(3)
}
var myArray = arrayOf(
        arrayOf("One", "Two"),
        arrayOf("Three", "Four", "Five")
)

fun main(args: Array<String>) {
    println("Pets size= ${pets.size}")
    println("Pets[0]= ${pets[0]}")
    println("Pets[1]= ${pets[1]}")
    println("Pets[2]= ${pets[2]}")

    table[0][0] = 10
    table[1][1] = 20

    println("Table[0][0]= ${table[0][0]}")
    println("Table[1][1]= ${table[1][1]}")
    println("Table[2][2]= ${table[2][2]}")
}