import kotlin.test.*

fun main(){
    fun testing(actual:Int, expected:Int) {
        assertEquals(expected.toLong(), actual.toLong())
    }

        println("Fixed Tests nbDig")
        testing(nbDig(10, 1), 4)
        testing(nbDig(25, 1), 11)
        testing(nbDig(5750, 0), 4700)
        testing(nbDig(11011, 2), 9481)

//    val string = "12314567"
//    println("1's in string = ${string.count{it=='1'}}")
}


fun nbDig(n:Int, d:Int):Int {
    //Square all numbers from 0..n
    //Check the digit 'd' appears in how many of these numbers
    var appearance = 0
    val listOfSquaredNumbers = arrayListOf<Long>()

    for (i in 0..n){
        listOfSquaredNumbers.add((i*i).toLong())
    }
    for (i in listOfSquaredNumbers){
        appearance += i.toString().count {it.toString() == d.toString()}
    }
    return appearance
}