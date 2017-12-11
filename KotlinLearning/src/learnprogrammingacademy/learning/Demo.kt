package learnprogrammingacademy.learning

var pets = arrayOf("Parrot", "Cat", "Dog")
var table = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
)

fun main(args: Array<String>) {
    for (index in pets.indices){
        println("pets[$index]= ${pets[index]}")
    }

    for(pet in pets){
        println("pet= $pet")
    }

    for(value in 1..10 step 2){
        println("value= $value")
    }

    for((index, value) in pets.withIndex()){
        println("Element at index= $index = $value")
    }

    for(row in 0 until table.size){
        println("Row= ${table[row]}")
        for(column in 0 until table[row].size){
            println("Number= ${table[row][column]}")
        }
    }
}