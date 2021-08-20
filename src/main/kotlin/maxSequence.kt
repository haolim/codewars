import java.lang.Integer.max

fun maxSequence (arr: List<Int>): Int {
    var currentSum = 0
    var maxSum = 0
    arr.forEach {
        currentSum = max(0, currentSum + it)
        maxSum = max(currentSum, maxSum)
    }
    return maxSum
}

fun main () {
    println(maxSequence(emptyList()))
    println(maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}
