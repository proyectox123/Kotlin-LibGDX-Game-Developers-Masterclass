package learnprogrammingacademy.learning

/*
Write class that represents a person
Person has 3 properties/fields: firstName, lastName, age
Write setter/set block for age to limit age between 0 and 100
Use init block to initialize age
Create read only property fullName (firstName + lastName)
In main create instance of person
Print firstName, last, fullName and age
Tip: Create method in person class to print properties
 */

class Person(private var firstName: String, private var lastName: String, age: Int){

    var age: Int = 0
        set(value){
            field = when {
                value < 0 -> 0
                value > 100 -> 100
                else -> value
            }
        }

    private val fullName: String
        get() = "$firstName $lastName"

    init {
        this.age = age
    }

    fun printInfo() = println("firstName= $firstName lastName= $lastName fullName= $fullName age= $age")
}

fun main(args: Array<String>) {
    val person1 = Person("John", "Smith", 25)
    person1.printInfo()

    val person2 = Person("Jimmy", "Winter", 120)
    person2.printInfo()

    val person3 = Person("Anthony", "Bell", -10)
    person3.printInfo()
}

/*
class Person(private val firstName: String, private val lastName: String){

    var age : Int = 0
        set(value) {
            if(value < 0 || value > 100){
                throw Exception("Age is not valid")
            }

            field = value
        }
    private val fullName: String
        get() {
            return "$firstName $lastName"
        }

    fun printInfo() = println("firstName= $firstName\nlastName= $lastName\nfullName=$fullName\nage=$age")
}

fun main(args: Array<String>) {
    val person = Person("Jimmy", "Jones")
    person.age = 12
    person.printInfo()
}
 */