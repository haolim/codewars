import kotlin.AssertionError.*;
import kotlin.test.*
import java.util.Arrays
import kotlin.system.measureTimeMillis

var notPrimesArray = mutableListOf<Long>()
var primesArray = mutableListOf<Long>()


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
    println("Execution time: ${time}")
}

fun isPrime (number: Long): Boolean {
    if (number in primesArray) {return true}
    if (number in notPrimesArray) {return false}
    for (i in 2..number / 2){
        if (number % i == 0L){
            notPrimesArray.add(i)
            return false
        }
    }
    primesArray.add(number)
    return true
}
//fun gapFind (g: Int, longArray: LongArray): LongArray{
//    for ((index, value) in longArray.withIndex()){
//        if (index+1 <= longArray.size-1) {
//            var tempVal = longArray[index+1]
//            var diff = tempVal - value
//            if (diff.toInt() == g){
//                return mutableListOf<Long>(value, tempVal).toLongArray()
//            }
//        }
//    }
//    var tempLong = mutableListOf<Long>()
//    return tempLong.toLongArray()
//}
fun gap(g:Int, m:Long, n:Long):LongArray {
    println("Size of g ${g} and size of m ${m} and size of n ${n}")
    var temp = mutableListOf<Long>()
    for (i in m..n){
        if (isPrime(i)){
            temp.add(i)
        }
    }
    println("Size of temp: ${temp.size}")
    for ((index, value) in temp.withIndex()){
        if (index+1 <= temp.size-1) {
            var tempVal = temp[index+1]
            var diff = tempVal - value
            if (diff.toInt() == g){
                return mutableListOf<Long>(value, tempVal).toLongArray()
            }
        }
    }
    var tempLong = mutableListOf<Long>()
    return tempLong.toLongArray()
//    var tempLong = gapFind(g, temp.toLongArray())
//    return tempLong
}
