package learnprogrammingacademy.learning

enum class SoldierClassType{
    LIGHT, HEAVY;

    fun isLight() = this == LIGHT
    fun isHeavy() = this == HEAVY
}

//<editor-fold desc="Interfaces">
interface Healable {
    fun heal(amount: Int)
}

interface Shooter {
    fun reload()
}
//</editor-fold>

//<editor-fold desc="Soldier class">
abstract class Soldier(health: Int, var weapon: String){

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
    var type = SoldierClassType.LIGHT

    init {
        this.health = health
        println("Soldier init called")
    }

    fun isLight() = type.isLight()
    fun isHeavy() = type.isHeavy()

    open fun attack(soldier: Soldier){
        val percentage = (damage * 0.1).toInt()
        val damageToTake = if(isLight() && type.isHeavy()){ //light vs heavy
            damage - percentage
        } else if(isHeavy() && type.isLight()){ //heavy vs light
            damage + percentage
        }else{
            damage
        }

//        val damageToTake = if(type.isLight() && soldier.type.isHeavy()){ //light vs heavy
//            damage - percentage
//        } else if(type.isHeavy() && soldier.type.isLight()){ //heavy vs light
//            damage + percentage
//        }else{
//            damage
//        }

//        val damageToTake = if(type == EnemyClassType.LIGHT && soldier.type == EnemyClassType.HEAVY){ //light vs heavy
//            damage - percentage
//        } else if(type == EnemyClassType.HEAVY&& soldier.type == EnemyClassType.LIGHT){ //heavy vs light
//            damage + percentage
//        }else{
//            damage
//        }

        println("Attacking ${soldier::class.simpleName} with $weapon")
        soldier.takeDamage(damageToTake)
    }

    private fun takeDamage(damageToTake: Int){
        health -= damageToTake
    }

    abstract fun run()
}
//</editor-fold>

class Pikeman(health: Int, var armor: Int) : Soldier(health, "pike"){
    init {
        type = SoldierClassType.HEAVY
        println("Pikeman init called")
    }

    override fun run() {
        println("Pikeman running...")
    }
}

class Archer(health: Int, arrowCount: Int) : Soldier(health, "bow"), Shooter{

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

    override fun attack(soldier: Soldier) {
        if (arrowCount <= 0) {
            println("No more arrows")
            reload()
        }

        super.attack(soldier)
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

class Pistolero(health: Int) : Soldier(health, "pistol"), Healable, Shooter{

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

    override fun attack(soldier: Soldier) {
        if (bulletCount <= 0) {
            println("No more bullets!")
            reload()
        }

        super.attack(soldier)
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
    val names = listOf("Jimmy", "Anthony", "John")
    for(name in names){
        println("name= $name uppercase= ${name.toUpperCase()}")
    }

    val pikeman : Soldier = Pikeman(100, 100)
    pikeman.damage = 15
    pikeman.run()

    val archer : Soldier = Archer(100, 5)
    archer.damage = 10
    archer.run()

    val pistolero : Soldier = Pistolero(100)
    pistolero.damage = 20
    pistolero.run()

    //val army : List<Soldier> = listOf<Soldier>(pikeman, archer, pistolero)
    val army = listOf(pikeman, archer, pistolero)
    for(soldier in army){
        println("soldier= ${soldier::class.simpleName} health= ${soldier.health} damage= ${soldier.damage}")
    }

    for(i in army.indices){
        val soldier = army[i]
        println("soldier= ${soldier::class.simpleName}")
    }
}