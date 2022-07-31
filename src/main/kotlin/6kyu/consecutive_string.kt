package `6kyu`

import org.junit.Test
import kotlin.test.assertEquals

fun main() {
    longestConsecMainTest().test()
}

fun longestConsec(strarr:Array<String>, k:Int):String {
    val consecCount = strarr.size - k
    if (strarr.isEmpty() || strarr.size-1 < k || k <= 0) return ""
    if (strarr.size == 1) return strarr[0]
    var longestString = ""
    var temp: String
    var index = 0

    if (k == 1) {
        while (index <= strarr.size-1) {
            temp = strarr[index]
            if (temp.length > longestString.length) {
                longestString = temp
            }
            index++
        }
    }
    else {
        while (index <= consecCount) {
            var count = 0
            temp = ""
            while (count < k) {
                temp += strarr[index+count]
                count++
            }
            if (temp.length > longestString.length) {
                longestString = temp
            }
            index++
        }
    }
    return longestString
}

class longestConsecMainTest {
    //.........................
    @Test
    fun test() {
        println("longestConsec Fixed Tests")
        testing(longestConsec(arrayOf<String>("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"), 2), "abigailtheta")
        testing(longestConsec(arrayOf<String>("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"), 1), "oocccffuucccjjjkkkjyyyeehh")

    }
    companion object {
        private fun testing(actual:String, expected:String) {
            assertEquals(expected, actual)
        }
    }
}