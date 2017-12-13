package learnprogrammingacademy.learning

class Dog constructor(private val color: String = "black") {

    init {
        println("Dog initialized with color value= $color")
    }

    fun printColor() = println("color= $color")
}

class Cat(private val name: String = "Tom", private val age: Int = 5){
//    private var age = 3

//    constructor(name: String = "Tom", age: Int = 5) : this(name){
//        this.age = age
//    }

    fun printInfo() = println("name= $name age= $age")
}

fun main(args: Array<String>) {
    callDog()
    callCat()
}

private fun callDog(){
    val dog = Dog()
    dog.printColor()

    val dog2 = Dog("gray")
    dog2.printColor()

    println(dog == dog2)
    println(dog === dog2)
}

private fun callCat(){
    val cat = Cat()
    cat.printInfo()

    val cat2 = Cat(name = "Jerry")
    cat2.printInfo()

    val cat3 = Cat(name = "Jimmy", age = 10)
    cat3.printInfo()
}