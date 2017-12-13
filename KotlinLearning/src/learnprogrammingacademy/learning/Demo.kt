package learnprogrammingacademy.learning

import java.util.*

fun main(args: Array<String>) {
    val deck = Stack<String>()

    deck.push("Ace of diamonds") //Bottom
    deck.push("Ace of hearts")
    deck.push("Ace of clubs")
    deck.push("Ace of spades")

    println("size= ${deck.size}")
    for(card in deck){
        println("card= $card")
    }

    while(deck.size > 0){
        val cardName = deck.pop()
        println("dealing card= $cardName")
    }

    println("size= ${deck.size}")
}