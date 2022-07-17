package `6kyu`
import org.junit.Test
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.util.*
import kotlin.test.*

// fun loop(random: Random, int: Int): Int {
// 	(1..int).forEach { random.nextInt() }
// 	return random.nextInt()
// }
// the one above works but it doesn't satisfy the condition

// ***********************************************
// ******************* MENTION *******************
// Please remove the comment above to pass the test
// ******************* MENTION *******************
// ***********************************************


tailrec fun loop(random: Random, int: Int): Int {
    if (int <= 0) return random.nextInt()
    else {
        random.nextInt()
        return loop(random, int - 1)
    }
}

fun main() {
    KotlinTricks4().loopTest()
}

class KotlinTricks4 {
    @Test
    fun loopTest() {
        fun loopTester(random: Random, int: Int): Int {
            (1..int).forEach { random.nextInt() }
            return random.nextInt()
        }
        (0..100).forEach {
            val i = System.currentTimeMillis()
            assertEquals(loopTester(Random(i), 10000), loop(Random(i), 10000))
        }
    }
}