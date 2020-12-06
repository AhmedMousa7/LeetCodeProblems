import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main(){
    val (value, duration) = measureTimedValue {
        rob(arrayOf(1,2,0,5).toIntArray())
    }
    println(value)
    println(duration)
}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    val dp = IntArray(nums.size + 1)
    dp[1] = nums[0]
    for (i in 1 until nums.size) {
        dp[i + 1] = max(dp[i], dp[i - 1] + nums[i])
    }

    return dp[nums.size]
}