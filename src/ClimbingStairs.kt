import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main(){
    val (value, duration) = measureTimedValue {
        climbStairs(7)
    }
    println(value)
    println(duration)
}

fun climbStairs(n: Int): Int {
    if (n in 1..3) return n
    val bottom_up = IntArray(n + 1)
    bottom_up[1] = 1
    bottom_up[2] = 2
    bottom_up[3] = 3

    for (i in 4..n)
        bottom_up[i] = bottom_up[i - 1] + bottom_up[i - 2]

    return bottom_up[n]
}