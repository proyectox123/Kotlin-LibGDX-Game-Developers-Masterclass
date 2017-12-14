package learnprogrammingacademy.learning

class Health(var amount: Int)

class Weapon(var name: String)

class Soldier(var name: String, var health: Health, var weapon: Weapon){
    override fun toString() = "name='$name', health=${health.amount}, weapon=${weapon.name}"
}

fun main(args: Array<String>) {
    //Pikeman
    val pikemanHealth= Health(100)
    val pike = Weapon("pike")
    val pikeman = Soldier("pikeman", pikemanHealth, pike)

    println("pikeman= $pikeman")

    //Archer
    val archerHealth= Health(80)
    val bow = Weapon("bow")
    val archer = Soldier("archer", archerHealth, bow)

    println("archer= $archer")
}