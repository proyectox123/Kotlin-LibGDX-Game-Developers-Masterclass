package learnprogrammingacademy.learning

var person : String? = null
var lives = 0

var pet :String? = null

fun main(args: Array<String>) {
    //person.toUpperCase() // Compilation error
    //person!!.toUpperCase() // Null pointer exception in case person is null
    person = person?.toUpperCase()
    println("Person= $person")

    person = "John"
    person = person?.toUpperCase()
    println("Person= $person")

    println("Lives= ${lives == 0}")

    var anotherPerson : String? = null
    println("Another person= $anotherPerson")
    println("Another person null= ${anotherPerson === null}")
    println("Another person isEmpty= ${anotherPerson.isNullOrEmpty()}")

    anotherPerson = ""
    println("Another person= $anotherPerson")
    println("Another person null= ${anotherPerson === null}")
    println("Another person isEmpty= ${anotherPerson.isNullOrEmpty()}")

    println("Pet is null= ${pet === null}")
    val dog = pet?.toUpperCase()
    println("Dog= ${dog?.startsWith("b")}")
}