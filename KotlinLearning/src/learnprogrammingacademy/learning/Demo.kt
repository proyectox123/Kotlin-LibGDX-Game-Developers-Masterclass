package learnprogrammingacademy.learning

class Player {
    private var health = 150
    private var alive = true

    fun reduceHealth(amount: Int){
        setHealth(health - amount)
    }

    private fun setHealth(value: Int){
        var newHealth = value
        if(value <= 0){
            newHealth = 0
            alive = false
        }

        health = newHealth
    }

    fun getHealth() = health

    fun isAlive() = alive

    fun respawn(){
        if(!alive){
            health = 150
            alive = true
        }
    }

    fun printInfo() = println("health= $health alive= $alive")
}

fun main(args: Array<String>) {
    val player = Player()

    player.reduceHealth(100)
    player.printInfo()

    player.reduceHealth(100)
    player.printInfo()

    player.respawn()
    player.printInfo()
}