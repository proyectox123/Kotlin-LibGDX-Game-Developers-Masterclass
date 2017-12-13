package learnprogrammingacademy.learning

enum class EnemyClassType{
    LIGHT, HEAVY;

    fun isLight() = this == LIGHT
    fun isHeavy() = this == HEAVY
}

interface Healable {
    fun heal(amount: Int)
}

interface Shooter {
    fun reload()
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
    var type = EnemyClassType.LIGHT

    init {
        this.health = health
        println("Enemy init called")
    }

    fun isLight() = type.isLight()
    fun isHeavy() = type.isHeavy()

    open fun attack(enemy: Enemy){
        val percentage = (damage * 0.1).toInt()
        val damageToTake = if(isLight() && type.isHeavy()){ //light vs heavy
            damage - percentage
        } else if(isHeavy() && type.isLight()){ //heavy vs light
            damage + percentage
        }else{
            damage
        }

//        val damageToTake = if(type.isLight() && enemy.type.isHeavy()){ //light vs heavy
//            damage - percentage
//        } else if(type.isHeavy() && enemy.type.isLight()){ //heavy vs light
//            damage + percentage
//        }else{
//            damage
//        }

//        val damageToTake = if(type == EnemyClassType.LIGHT && enemy.type == EnemyClassType.HEAVY){ //light vs heavy
//            damage - percentage
//        } else if(type == EnemyClassType.HEAVY&& enemy.type == EnemyClassType.LIGHT){ //heavy vs light
//            damage + percentage
//        }else{
//            damage
//        }

        println("Attacking ${enemy::class.simpleName} with $weapon")
        enemy.takeDamage(damageToTake)
    }

    private fun takeDamage(damageToTake: Int){
        health -= damageToTake
    }

    abstract fun run()
}

class Pikeman(health: Int, var armor: Int) : Enemy(health, "pike"){
    init {
        type = EnemyClassType.HEAVY
        println("Pikeman init called")
    }

    override fun run() {
        println("Pikeman running...")
    }
}

class Archer(health: Int, arrowCount: Int) : Enemy(health, "bow"), Shooter{

    var arrowCount: Int = 5
        private set(value) {
            field = if (field > 5){
                5
            }else if (field < 0){
                0
            }else{
                value
            }
        }

    init {
        println("Archer init called")
    }

    override fun attack(enemy: Enemy) {
        if (arrowCount <= 0) {
            println("No more arrows")
            reload()
        }

        super.attack(enemy)
        arrowCount--
        println("Arrows left= $arrowCount")
    }

    override fun run() {
        println("Archer running...")
    }

    override fun reload(){
        println("Reloading bow...")
        arrowCount = 5
    }
}

class Pistolero(health: Int) : Enemy(health, "pistol"), Healable, Shooter{

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

    override fun reload(){
        println("Reloading pistol...")
        bulletCount = 6
    }
}

fun main(args: Array<String>) {
    val pikeman : Enemy = Pikeman(100, 100)
    pikeman.damage = 15
    pikeman.run()

    val archer : Enemy = Archer(100, 5)
    archer.damage = 10
    archer.run()

    val pistolero : Enemy = Pistolero(100)
    pistolero.damage = 20
    pistolero.run()

    println("pikeman type=${pikeman.type}")
    println("archer type=${archer.type}")
    println("pistolero type=${pistolero.type}")

    println("pikeman heavy=${pikeman.isHeavy()} light=${pikeman.isLight()}")
    println("archer heavy=${archer.isHeavy()} light=${archer.isLight()}")
    println("pistolero heavy=${pistolero.isHeavy()} light=${pistolero.isLight()}")

    pikeman.attack(archer)
    archer.attack(pikeman)
    println("pikeman health= ${pikeman.health} archer health= ${archer.health}")

    pikeman.attack(pistolero)
    pistolero.attack(pikeman)
    println("pikeman health= ${pikeman.health} pistolero health= ${pistolero.health}")

    archer.attack(pistolero)
    pistolero.attack(archer)
    println("archer health= ${archer.health} pistolero health= ${pistolero.health}")
}