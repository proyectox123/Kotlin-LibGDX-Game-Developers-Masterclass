package learnprogrammingacademy.learning

interface Healable {
    fun heal(amount: Int)
}

abstract class Enemy(health: Int, var weapon: String){

    var health: Int = 0
        set(value) {
            field = if(value < 0){
                0
            }else if(value > 100){
                100
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

    private fun takeDamage(damageToTake: Int){
        health -= damageToTake
    }

    abstract fun run()
}

class Pikeman(health: Int, var armor: Int) : Enemy(health, "pike"){
    init {
        println("Pikeman init called")
    }

    override fun run() {
        println("Pikeman running...")
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

    override fun run() {
        println("Archer running...")
    }
}

class Pistolero(health: Int) : Enemy(health, "pistol"), Healable{

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

    override fun run() {
        println("Pistolero running...")
    }

    override fun heal(amount: Int) {
        if(amount < 0){
            println("Can't heal with negative amount")
            return
        }

        println("healing with amount= $amount")
        health += amount
    }

    private fun reload(){
        println("Reloading pistol...")
        bulletCount = 6
    }
}

fun main(args: Array<String>) {
    val pikeman : Enemy = Pikeman(100, 100)
    pikeman.damage = 5
    pikeman.run()

    val archer : Enemy = Archer(100, 5)
    archer.damage = 5
    archer.run()

    val pistolero : Enemy = Pistolero(100)
    pistolero.damage = 10
    pistolero.run()

    while (archer.health > 0){
        pistolero.attack(archer)
        archer.attack(pistolero)
    }

    println("archer died")
    println("pistolero health= ${pistolero.health}")
    if(pistolero is Healable){
        pistolero.heal(10)
        println("pistolero health= ${pistolero.health}")

        pistolero.heal(-10)
        println("pistolero health= ${pistolero.health}")

        pistolero.heal(200)
        println("pistolero health= ${pistolero.health}")
    }

    //pistoleroVsPikeman()
    //pistoleroVsArcher()
}

private fun pistoleroVsPikeman(){
    println("******************************** pistoleroVsPikeman ********************************")
    val pikeman : Enemy = Pikeman(100, 100)
    pikeman.damage = 5
    pikeman.run()
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