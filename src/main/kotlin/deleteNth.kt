import org.junit.Assert.assertArrayEquals

fun deleteNth(elements:IntArray, maxOcurrences:Int):IntArray {
    //val tempArray = elements
//    val tempMap = mutableMapOf<Int, Int>()
//    for ((index, value) in elements.withIndex()){
//        tempMap[index] = value
//    }
//    for ((index,value) in tempMap){
//        println ("Index is $index and value is $value")
//    }
//    if (tempMap.values.count() >= maxOcurrences) {
//        println(tempMap.values.count())
//    }
//    val tempMap2 = tempMap.filterValues { it >= maxOcurrences }.values
//    for (i in tempMap2){
//        println ("i is $i")
//    }
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
