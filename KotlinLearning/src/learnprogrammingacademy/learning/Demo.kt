package learnprogrammingacademy.learning

class Player {
    private var health = 150
        set(value){
            println("setter block")
            var newHealth = value
            if(value <= 0){
                newHealth = 0
            }

            field = newHealth
        }

    val alive
        get() = health > 0

    fun reduceHealth(amount: Int){
        health -= amount
    }

    fun respawn(){
        if(!alive){
            health = 150
        }
    }

    fun printInfo() = println("health= $health alive= $alive")
}

fun main(args: Array<String>) {
    val player = Player()
    println("player alive= ${player.alive}")

    player.reduceHealth(100)
    player.printInfo()

    player.reduceHealth(100)
    player.printInfo()

    player.respawn()
    player.printInfo()
}