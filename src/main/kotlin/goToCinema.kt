import kotlin.math.ceil
import kotlin.test.*

private fun testing(actual:Int, expected:Int) {
    assertEquals(expected, actual)
}

fun movie(card:Int, ticket:Int, perc:Double):Int {
    var count = 0
    var ticketTemp = ticket
    var cardTemp = card.toDouble()
    var cumTicketDiscounted = ticket.toDouble()
    while(ticketTemp <= ceil(cardTemp) || cardTemp==0.0){
        count++
        ticketTemp = ticket*count
        cumTicketDiscounted *= perc
        cardTemp += cumTicketDiscounted

    }
    return count
}

fun main (){
    testing(movie(500, 15, 0.9), 43)
    testing(movie(100, 10, 0.95), 24)
    testing(movie(0, 10, 0.95), 2)
    testing(movie(793428, 15, 0.64), 52898)
}