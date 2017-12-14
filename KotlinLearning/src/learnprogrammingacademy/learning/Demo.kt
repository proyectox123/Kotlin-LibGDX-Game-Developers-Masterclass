package learnprogrammingacademy.learning

/*
Write class Armor similar to Health
Create property armor in Soldier class
When printing soldier, make sure it prints armor (modify toString method)
Add armor to Pikeman and archer inside main method
Create swordsman soldier and print to console
 */

class Armor(var amount: Int)

class Health(var amount: Int)

class Weapon(var name: String)

class Soldier(var name: String, var health: Health, var weapon: Weapon, var armor: Armor){
    override fun toString() = "name='$name', health=${health.amount}, weapon=${weapon.name}, armor=${armor.amount}"
}

fun main(args: Array<String>) {
    //Pikeman
    val pikemanHealth= Health(100)
    val pike = Weapon("pike")
    val pikemanArmor = Armor(100)
    val pikeman = Soldier("pikeman", pikemanHealth, pike, pikemanArmor)

    println("pikeman= $pikeman")

    //Archer
    val archerHealth= Health(80)
    val bow = Weapon("bow")
    val archerArmor = Armor(80)
    val archer = Soldier("archer", archerHealth, bow, archerArmor)

    println("archer= $archer")

    //Swordsman
    val swordsmanHealth= Health(60)
    val sword = Weapon("bow")
    val swordsmanArmor = Armor(60)
    val swordsman = Soldier("swordsman", swordsmanHealth, sword, swordsmanArmor)

    println("swordsman= $swordsman")
}