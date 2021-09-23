package `5kyu`

import junit.framework.Assert.assertEquals
import org.junit.Test

fun main() {
    TestExample().FixedTests()
}

fun incrementString(str: String) : String {
    val getString = StringBuilder()
    val getNumber = StringBuilder()
    val integer: Int

    getString.append(
        str.filter {
            !it.isDigit()
        }
    )
    getNumber.append(
        str.filter {
            it.isDigit()
        }
    )

    if (getNumber.isNotEmpty()) {
        integer = getNumber.toString().toInt() + 1
    }
    else {
        integer = 1
    }

    getString.append(integer.toString().padStart(getNumber.length,'0'))

    return getString.toString()
}

class TestExample {
    @Test
    fun FixedTests() {
        assertEquals(incrementString("foobar000"), "foobar001")
        assertEquals(incrementString("foobar999"), "foobar1000")
        assertEquals(incrementString("foobar00999"), "foobar01000")
        assertEquals(incrementString("foo"), "foo1")
        assertEquals(incrementString("foobar001"), "foobar002")
        assertEquals(incrementString("foobar1"), "foobar2")
        assertEquals(incrementString("1"), "2")
        assertEquals(incrementString(""), "1")
        assertEquals(incrementString("009"), "010")
    }
}