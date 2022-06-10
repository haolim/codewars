package `6kyu`

import org.junit.Test
import kotlin.test.assertEquals

fun spinWords(sentence: String): String {
    val spinWordList = mutableListOf<String>()
    val wordList = sentence.split(' ')
    for (i in wordList) {
        spinWordList += if (i.length > 4) {
            reverseWord(i)
        } else {
            i
        }
    }
    return spinWordList.joinToString(" ")

}

fun reverseWord(word: String): String {
    val myList = mutableListOf<Char>()
    var charPosition = word.length - 1

    while (charPosition != -1) {
        myList.add(word[charPosition])
        charPosition -= 1
    }
    return myList.joinToString("")
}


fun main() {
    val test = SpinWordsTests()
    test.test1()
    test.test2()
    test.test3()
    test.test4()
    test.test5()
    test.test6()
}


class SpinWordsTests {

    @Test
    fun test1() {
        assertEquals("emocleW", spinWords("Welcome"))
    }

    @Test
    fun test2() {
        assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"))
    }

    @Test
    fun test3() {
        assertEquals("This is a test", spinWords("This is a test"))
    }

    @Test
    fun test4() {
        assertEquals("This is rehtona test", spinWords("This is another test"))
    }

    @Test
    fun test5() {
        assertEquals("You are tsomla to the last test", spinWords("You are almost to the last test"))
    }

    @Test
    fun test6() {
        assertEquals("Just gniddik ereht is llits one more", spinWords("Just kidding there is still one more"))
    }
}