package `5kyu`

import kotlin.test.assertEquals
import org.junit.Test
import kotlin.math.pow


fun main() {
    TestExampleHexToRGB().testFixed()
}

data class RGB(val r: Int, val g: Int, val b: Int)

fun hexStringToRGB(hexString: String): RGB {
    val tempStr = hexString.removePrefix("#").toUpperCase()
    var rgbList = listOf<Int>()
    var sum = 0.0
    for ((index, value) in tempStr.withIndex()) {
        sum += base16ToBase10(value.toString(), index%2)
        if (index%2 == 1) {
            rgbList += sum.toInt()
            sum = 0.0
        }
    }
    return RGB(rgbList[0], rgbList[1], rgbList[2])
}

fun base16ToBase10(str: String, index: Int): Double {
    var power = if (index == 0) {
        1
    } else {
        0
    }
    val exp = 16.0.pow(power)
    return when(str) {
        "F" -> 15*exp
        "E" -> 14*exp
        "D" -> 13*exp
        "C" -> 12*exp
        "B" -> 11*exp
        "A" -> 10*exp
        "9" -> 9*exp
        "8" -> 8*exp
        "7" -> 7*exp
        "6" -> 6*exp
        "5" -> 5*exp
        "4" -> 4*exp
        "3" -> 3*exp
        "2" -> 2*exp
        "1" -> 1*exp
        else -> 0.0
    }
}

class TestExampleHexToRGB {
    @Test
    fun testFixed() {
        assertEquals(RGB(r = 255, g = 153, b = 51), hexStringToRGB("#FF9933"))
        assertEquals(RGB(r = 190, g = 173, b = 237), hexStringToRGB("#beaded"))
        assertEquals(RGB(r = 0, g = 0, b = 0), hexStringToRGB("#000000"))
        assertEquals(RGB(r = 17, g = 17, b = 17), hexStringToRGB("#111111"))
        assertEquals(RGB(r = 250, g = 52, b = 86), hexStringToRGB("#Fa3456"))
    }
}