
fun bouncingBall (h: Double, bounce: Double, window:Double) : Int {
    var value = checkValid(h, bounce, window)
    if (value==1){
        var currentHeight = h

        while (currentHeight > window){
            currentHeight *= bounce
            if (currentHeight > window) {
                value += 2
            }
        }
    }else {
        return -1
    }
    return value
}

fun checkValid (h: Double, bounce: Double, window: Double): Int {
    val value = when {
        h<=0 -> -1
        bounce >= 1 || bounce <= 0 -> -1
        window >= h -> -1
        else -> 1 // initial fall is seen
    }
    return value
}

fun main () {
    println(bouncingBall (3.0, 0.66, 1.5)) // 3
    println(bouncingBall (30.0, 0.66, 1.5)) // 15
}