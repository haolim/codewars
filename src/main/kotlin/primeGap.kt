import java.util.*
import kotlin.test.*
import kotlin.system.measureTimeMillis

fun main (){
    val time = measureTimeMillis {
        assertEquals("[101, 103]", Arrays.toString(gap(2, 100, 110)))
        assertEquals("[103, 107]", Arrays.toString(gap(4, 100, 110)))
        gap(6,100,110)
        gap(8,300,400)
        gap(10,300,400)
        gap(4,30000,100000)
        gap(6,30000,100000)
    }

    println("Execution time: $time")
}
fun isPrime (number: Long): Boolean {
    for (i in 2..number / 2){
        if (number % i == 0L){
            return false
        }
    }

    return true
}

fun gap(g:Int, m:Long, n:Long):LongArray {
    var previousPrime = 0L
    for (i in m..n){
        if (isPrime(i)){
            if (i - previousPrime == g.toLong()){
                return mutableListOf(previousPrime, i).toLongArray()
            }
            previousPrime = i
        }
    }
    return mutableListOf<Long>().toLongArray()
}
