

fun main () {
    println(persistence(39)) // 3
    println(persistence(4)) // 0
    println(persistence(25)) // 2
    println(persistence(999)) // 4
}

fun persistence(num: Int) : Int {
    var count = 0
    var tempList = num.toString().toList().map { it.toString().toInt() }.toTypedArray()
    if (tempList.size > 1){
        while (tempList.size != 1){
            count++
            tempList = (tempList.reduce { acc, i -> acc * i}).toString().map { it.toString().toInt() }.toTypedArray()
        }
    }else {
        return count
    }
    return count
}