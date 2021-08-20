import kotlin.test.assertEquals

fun nbYear(pp0:Int, percent:Double, aug:Int, p:Int):Int {
    var value = pp0.toDouble()
    var count = 0
    while (value < p){
        count += 1
        value = (value + (value * (percent/100)) + aug)
    }
    return count
}

fun main () {
    fun testing(actual:Int, expected:Int) {
        assertEquals(expected.toLong(), actual.toLong())
    }
    println("Fixed Tests: nbYear")
    testing(nbYear(1500, 5.0, 100, 5000), 15)
    testing(nbYear(1500000, 2.5, 10000, 2000000), 10)
}