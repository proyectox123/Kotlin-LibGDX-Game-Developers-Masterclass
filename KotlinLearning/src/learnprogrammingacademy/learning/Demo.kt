package learnprogrammingacademy.learning

open class Enemy(var health: Int, var weapon: String){
    init {
        println("Enemy init called")
    }

    open fun attack(){
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

    override fun attack() {
        if (arrowCount <= 0) {
            println("No more arrows")
            return
        }

        super.attack()
        arrowCount--
        println("Arrows left= $arrowCount")
    }
}

fun main(args: Array<String>) {
    val pikeman = Pikeman(100, 100)
    pikeman.attack()

    val archer = Archer(100, 5)
    archer.attack()
    archer.attack()
    archer.attack()
    archer.attack()
    archer.attack()
    archer.attack()
    archer.attack()
}