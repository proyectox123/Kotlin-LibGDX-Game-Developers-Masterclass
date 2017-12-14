package learnprogrammingacademy.learning

fun main(args: Array<String>) {
//    val weaponsByDamage = hashMapOf<String, Int>()
//    weaponsByDamage.put("pike", 10)
//    weaponsByDamage.put("arrow", 15)
//    weaponsByDamage.put("sword", 20)
//    weaponsByDamage.put("pistol", 30)

    val weaponsByDamage = hashMapOf(
            "pike" to 10,
            "arrow" to 15,
            "sword" to 20,
            "pistol" to 30
    )

    for((key, value) in weaponsByDamage){
        println("key= $key value= $value")
    }

    for(key in weaponsByDamage.keys){
        println("key= $key")
    }

    for(value in weaponsByDamage.values){
        println("value= $value")
    }

    //getting / setting values
    println("sword has damage= ${weaponsByDamage["sword"]}")
    //weaponsByDamage.put("sword", 35)
    weaponsByDamage["sword"] = 35
    println("sword has new damage= ${weaponsByDamage["sword"]}")
}