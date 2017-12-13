package learnprogrammingacademy.learning

open class Enemy(health: Int, var weapon: String){

    var health: Int = 0
        set(value) {
            field = if(health < 0){
                0
            }else{
                value
            }
        }
    var damage: Int = 0

    init {
        println("Enemy init called")
    }

    open fun attack(enemy: Enemy){
        println("Attacking ${enemy::class.simpleName} with $weapon")
        enemy.takeDamage(damage)
    }

    fun takeDamage(damageToTake: Int){
        health -= damageToTake
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

    override fun attack(enemy: Enemy) {
        if (arrowCount <= 0) {
            println("No more arrows")
            return
        }

        super.attack(enemy)
        arrowCount--
        println("Arrows left= $arrowCount")
    }
}

fun main(args: Array<String>) {
    val pikeman : Enemy = Pikeman(100, 100)
    pikeman.damage = 40
    val archer : Enemy = Archer(100, 5)
    archer.damage = 60

    pikeman.attack(archer)
    println("pikeman health= ${pikeman.health} archer health= ${archer.health}")
    archer.attack(pikeman)
    println("pikeman health= ${pikeman.health} archer health= ${archer.health}")

    pikeman.attack(archer)
    println("pikeman health= ${pikeman.health} archer health= ${archer.health}")
    archer.attack(pikeman)
    println("pikeman health= ${pikeman.health} archer health= ${archer.health}")
}