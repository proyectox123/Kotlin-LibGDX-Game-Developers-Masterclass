package learnprogrammingacademy.learning

/*
Create new component class (Speed implements BasicComponent)
Medic has speed 10, Pikeman has speed 6
Print to console speed for each unit by getting component from Unit
 */

interface BasicComponent

class Armor(var amount: Int) : BasicComponent

class Health(var amount: Int) : BasicComponent

class Weapon(var name: String) : BasicComponent

class Speed(var amount: Int) : BasicComponent

class Unit(var name: String){

    private val componentsByName = hashMapOf<String, BasicComponent>()

    fun removeComponent(name: String) = componentsByName.remove(name)

    operator fun set(name: String, component: BasicComponent) = componentsByName.put(name, component)

    operator fun get(name: String) : BasicComponent? = componentsByName[name]

    override fun toString(): String {
        val componentsString = componentsByName.keys.joinToString(",")
        return "name= $name components= $componentsString"
    }
}

fun main(args: Array<String>) {
    //Pikeman
    val pikeman = Unit("pikeman")
    pikeman["health"] = Health(100)
    pikeman["weapon"] = Weapon("pike")
    pikeman["armor"] = Armor(100)
    pikeman["speed"] = Speed(6)
    println("pikeman= $pikeman")

    //Archer
    val archer = Unit("archer")
    archer["health"] = Health(80)
    archer["weapon"] = Weapon("bow")
    archer["armor"] = Armor(80)
    println("archer= $archer")

    //Swordsman
    val swordsman = Unit("swordsman")
    swordsman["health"] = Health(60)
    swordsman["weapon"] = Weapon("bow")
    swordsman["armor"] = Armor(60)
    println("swordsman= $swordsman")

    //Medic
    val medic = Unit("medic")
    medic["health"] = Health(50)
    medic["speed"] = Speed(10)
    println("medic= $medic")

    val medicWeapon = medic["weapon"]
    println("medic hasWeapon ${medicWeapon != null}")
    val medicSpeed = medic["speed"] as Speed
    println("medic speed= ${medicSpeed.amount}")

    val pikemanWeapon = pikeman["weapon"] as Weapon
    println("pikeman hasWeapon= ${pikemanWeapon.name}")
    val pikemanSpeed = pikeman["speed"] as Speed
    println("medic speed= ${pikemanSpeed.amount}")
}