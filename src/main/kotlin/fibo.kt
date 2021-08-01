

fun main () {
    println(fiboRec(8))

}

fun fiboRec (size: Int, a: Long = 1, b: Long = 0): Long {

        if (size ==0) {
            return b
        } else {
            return fiboRec(size-1, b, a + b)
        }
}