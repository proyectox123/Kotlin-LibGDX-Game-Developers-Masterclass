package learnprogrammingacademy.learning

class Ship {
    private val bullets = arrayOf("laser", "fire")

    var hitPoints = 100
        private set

    fun fire(){
        val bullet = if(hitPoints > 50){
            bullets[1]
        }else{
            bullets[0]
        }

        println("Firing $bullet")
    }

    fun takeDamage(amount: Int){
        if(amount > 0){
            hitPoints -= amount
            if(hitPoints < 0){
                hitPoints = 0
            }
        }
    }
}

fun main(args: Array<String>) {
    val ship = Ship()
    ship.fire()
    ship.takeDamage(10)
    println("ship hitPoints= ${ship.hitPoints}")

    ship.fire()
    ship.takeDamage(50)
    println("ship hitPoints= ${ship.hitPoints}")

    ship.fire()
    ship.takeDamage(100)
    println("ship hitPoints= ${ship.hitPoints}")
}