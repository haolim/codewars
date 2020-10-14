import org.junit.Assert.assertArrayEquals

fun deleteNth(elements:IntArray, maxOcurrences:Int):IntArray {
    val tempArray = mutableListOf<Int>()
    for (i in elements){
        if (tempArray.count {it == i} < maxOcurrences){
            tempArray.add(i)
        }
    }
    return tempArray.toIntArray()
}

fun main () {
      assertArrayEquals(intArrayOf(20, 37, 21),
                    deleteNth(intArrayOf(20, 37, 20, 21), 1)
            )
            assertArrayEquals(
                    intArrayOf(1, 1, 3, 3, 7, 2, 2, 2),
                    deleteNth(intArrayOf(1, 1, 3, 3, 7, 2, 2, 2, 2), 3)
            )
            assertArrayEquals(
                    intArrayOf(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5),
                    deleteNth(intArrayOf(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3)
            )
            assertArrayEquals(
                    intArrayOf(1, 1, 1, 1, 1),
                    deleteNth(intArrayOf(1, 1, 1, 1, 1), 5)
            )
            assertArrayEquals(
                    intArrayOf(),
                    deleteNth(intArrayOf(), 5)
            )
}
