package `5kyu`

import org.junit.Test
import kotlin.math.ceil
import kotlin.test.assertEquals

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {


    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.count()
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            return ceil(itemCount.toDouble() / itemsPerPage.toDouble()).toInt()
        }


    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */

    fun pageItemCount(pageIndex: Int): Int {
        var numItems = itemCount
        val myList = mutableListOf<Int>()

        while (numItems != 0) {
            if ((numItems - itemsPerPage) <= 0) {
                myList += numItems
                numItems = 0
            } else {
                myList += itemsPerPage
                numItems -= itemsPerPage
            }
        }
        return myList.getOrElse(pageIndex) {-1}
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int {
        if (itemIndex > itemCount || itemIndex < 0 || collection.isEmpty()) {
            return -1
        }
        if (itemIndex < itemsPerPage) {
            return 0
        } else {
            return ceil(itemIndex.toDouble()/itemsPerPage.toDouble()).toInt() - 1
        }
    }
}

fun main() {

    PaginationHelperTest().testItemCount()
    PaginationHelperTest().testPageCount()
    PaginationHelperTest().testPageIndex()
}

class PaginationHelperTest() {

    @Test
    fun testItemCount() {
        val helper = PaginationHelper<Int>(listOf(1,2,3,4,5,6,7,8,9,10,11), 3)
        assertEquals(11, helper.itemCount, "itemCount is returning incorrect value")
    }

    @Test
    fun testPageCount() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(2, helper.pageCount, "pageCount is returning incorrect value")
    }

    fun testPageIndex() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(1, helper.pageIndex(5), "pageIndex is returning incorrect value")
        assertEquals(0, helper.pageIndex(2), "pageIndex is returning incorrect value")
        assertEquals(-1, helper.pageIndex(20), "pageIndex is returning incorrect value")
        assertEquals(-1, helper.pageIndex(-10), "pageIndex is returning incorrect value")
    }
}