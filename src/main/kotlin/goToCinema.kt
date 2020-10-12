import kotlin.math.ceil
import kotlin.test.*

fun main (){
    println("Fixed Tests: movie")
    testing(movie(500, 15, 0.9), 43)
    testing(movie(100, 10, 0.95), 24)
    testing(movie(0, 10, 0.95), 2)
    testing(movie(793428, 15, 0.64), 52898)
}
private fun testing(actual:Int, expected:Int) {
    assertEquals(expected, actual)
}

fun movie(card:Int, ticket:Int, perc:Double):Int {
    var count = 0
    var ticketTemp = ticket
    var cardTemp = card.toDouble()
    var cumTicketDiscounted = ticket.toDouble()
    while (ticketTemp <= ceil(cardTemp) || cardTemp==0.0){
        count++
//        println("count $count")
        ticketTemp = ticket*count
//        println("ticketTemp $ticketTemp")
        cumTicketDiscounted *= perc
//        println("cumTicketDiscounted $cumTicketDiscounted")
        cardTemp += cumTicketDiscounted
//        println("cardTemp $cardTemp")
    }
    return count
}
