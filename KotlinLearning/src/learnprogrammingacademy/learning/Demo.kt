package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    val dog = "Dog"
    val dog2 = String(charArrayOf('D', 'o', 'g'))

    println("dog == dog2 => ${dog == dog2}")//Structural equality (Check the content)
    println("dog === dog2 => ${dog === dog2}")//Reference equality

    val cat = "Cat"
    val cat2 = String(cat.toCharArray())
    val cat3 = cat2//Two referenes to sae object int memory

    println("reference equals => ${cat === cat2}")
    println("reference equals => ${cat === cat3}")
    println("reference equals => ${cat2 === cat3}")

    //Templates
    println("Dog= $dog Cat= $cat")

    //Raw
    println("""This is
my dog
$dog""")

    //Methods
    var lizard = "Lizard"
    println("Lizard first letter= ${lizard[0]}")
    println("contains= ${lizard.contains("iz")}")

    //Immutability
    lizard.toUpperCase() //It creates copy or new string object
    println("Lizard= $lizard")

    lizard = lizard.toUpperCase()
    println("Lizard= $lizard")
}