package learnprogrammingacademy.learning

/*
Write another class that inherits/extends from Enemy calls Pistolero
Pistolero has weapon pistol and 6 bullets
Add reload method from Pistolero but only can use it if there are no more bullets
Override attack method to fire bullet only if there are bullets left
If there are no more bullets reload then fire a bullet
Add code to main to simulate attack between Pistolero and archer/pikeman
Tip: Use loops instead of duplication calls to attach method
 */

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
        this.health = health
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
            //println("No more arrows")
            return
        }

        super.attack(enemy)
        arrowCount--
        println("Arrows left= $arrowCount")
    }
}

class Pistolero(health: Int) : Enemy(health, "pistol"){

    var bulletCount: Int = 6
        private set(value) {
            field = if (field > 6){
                6
            }else if (field < 0){
                0
            }else{
                value
            }
        }

    init {
        println("Pistolero init called")
    }

    override fun attack(enemy: Enemy) {
        if (bulletCount <= 0) {
            println("No more bullets!")
            reload()
            return
        }

        super.attack(enemy)
        bulletCount--
        println("Bullets left= $bulletCount")
    }

    private fun reload(){
        println("Reloading pistol...")
        bulletCount = 6
    }
}

fun main(args: Array<String>) {
    pistoleroVsPikeman()
    pistoleroVsArcher()
}

private fun pistoleroVsPikeman(){
    println("******************************** pistoleroVsPikeman ********************************")
    val pikeman : Enemy = Pikeman(100, 100)
    pikeman.damage = 5
    val pistolero : Enemy = Pistolero(100)
    pistolero.damage = 10

    battle(pikeman, pistolero)
}

private fun pistoleroVsArcher(){
    println("******************************** pistoleroVsArcher ********************************")
    val archer : Enemy = Archer(100, 5)
    archer.damage = 5
    val pistolero : Enemy = Pistolero(100)
    pistolero.damage = 10

    battle(archer, pistolero)
}

private fun battle(enemy1: Enemy, enemy2: Enemy){
    val enemy1Name = enemy1::class.simpleName
    val enemy2Name = enemy2::class.simpleName

    while (enemy1.health > 0 && enemy2.health > 0){
        enemy1.attack(enemy2)
        println("$enemy1Name health= ${enemy1.health} $enemy2Name health= ${enemy2.health}")
        if(enemy2.health > 0){
            enemy2.attack(enemy1)
            println("$enemy2Name health= ${enemy2.health} $enemy1Name health= ${enemy1.health}")
        }
    }

    println("${if(enemy1.health > 0) enemy1Name else enemy2Name} is the winner!")
}