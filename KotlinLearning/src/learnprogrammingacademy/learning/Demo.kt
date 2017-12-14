package learnprogrammingacademy.learning

interface BasicComponent

class Armor(var amount: Int) : BasicComponent

class Health(var amount: Int) : BasicComponent

class Weapon(var name: String) : BasicComponent

class Unit(var name: String){

    private val componentsByName = hashMapOf<String, BasicComponent>()

    fun addComponent(name: String, component: BasicComponent) = componentsByName.put(name, component)

    fun removeComponent(name: String) = componentsByName.remove(name)

    fun getComponent(name: String) : BasicComponent? = componentsByName[name]

    override fun toString(): String {
        val componentsString = componentsByName.keys.joinToString(",")
        return "name= $name components= $componentsString"
    }
}

fun main(args: Array<String>) {
    //Pikeman
    val pikemanHealth= Health(100)
    val pike = Weapon("pike")
    val pikemanArmor = Armor(100)
    val pikeman = Unit("pikeman")
    pikeman.addComponent("health", pikemanHealth)
    pikeman.addComponent("weapon", pike)
    pikeman.addComponent("armor", pikemanArmor)

    println("pikeman= $pikeman")

    //Archer
    val archerHealth= Health(80)
    val bow = Weapon("bow")
    val archerArmor = Armor(80)
    val archer = Unit("archer")
    archer.addComponent("health", archerHealth)
    archer.addComponent("weapon", bow)
    archer.addComponent("armor", archerArmor)

    println("archer= $archer")

    //Swordsman
    val swordsmanHealth= Health(60)
    val sword = Weapon("bow")
    val swordsmanArmor = Armor(60)
    val swordsman = Unit("swordsman")
    swordsman.addComponent("health", swordsmanHealth)
    swordsman.addComponent("weapon", sword)
    swordsman.addComponent("armor", swordsmanArmor)

    println("swordsman= $swordsman")

    //Medic
    val medicHealth = Health(50)
    val medic = Unit("medic")
    medic.addComponent("health", medicHealth)

    println("medic= $medic")

    val medicWeapon = medic.getComponent("weapon")
    println("medic hasWeapon ${medicWeapon != null}")

    val pikemanWeapon = pikeman.getComponent("weapon") as Weapon
    println("pikeman hasWeapon ${pikemanWeapon.name}")
}