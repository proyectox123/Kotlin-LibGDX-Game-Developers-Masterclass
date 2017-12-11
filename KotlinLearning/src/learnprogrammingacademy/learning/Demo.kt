package learnprogrammingacademy.learning

fun main(args: Array<String>) {
    val animals = arrayOf("Dog", "Cat", "Lizard", "Bird", "Snake")
    breakExample(animals)
    continueExample(animals)
}

private fun breakExample(animals: Array<String>) {
    breakForExample(animals)
    breakLambdaExample(animals)
}

@Suppress("LoopToCallChain")
private fun breakForExample(animals: Array<String>){
    println("*breakForExample")
    for(animal in animals){
        if(animal == "Lizard"){
            break
        }

        println(animal)
    }
}

private fun breakLambdaExample(animals: Array<String>){
    println("*breakLambdaExample")
    animals.asSequence()
            .takeWhile { it != "Lizard" }
            .forEach { println(it) }
}

private fun continueExample(animals: Array<String>){
    continueForExample(animals)
    continueLambdaExample(animals)
}

@Suppress("LoopToCallChain")
private fun continueForExample(animals: Array<String>){
    println("*continueForExample")
    for(animal in animals){
        if(animal == "Lizard"){
            continue
        }

        println(animal)
    }
}

private fun continueLambdaExample(animals: Array<String>){
    println("*continueLambdaExample")
    animals.asSequence()
            .filter { it != "Lizard" }
            .forEach { println(it) }
}