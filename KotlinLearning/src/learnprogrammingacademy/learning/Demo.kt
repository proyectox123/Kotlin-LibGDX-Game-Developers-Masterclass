package learnprogrammingacademy.learning

open class Enemy(var health: Int, var weapon: String){
    init {
        println("Enemy init called")
    }

    fun attack(){
        println("Attacking with $weapon")
    }
}

class Pikeman(health: Int, var armor: Int) : Enemy(health, "pike"){
    init {
        println("Pikeman init called")
    }
}

class Archer(health: Int, var arrowCount: Int) : Enemy(health, "bow"){
    init {
        println("Archer init called")
    }
}

fun main(args: Array<String>) {
    val pikeman = Pikeman(100, 100)
    pikeman.attack()

    val archer = Archer(100, 5)
    archer.attack()
}