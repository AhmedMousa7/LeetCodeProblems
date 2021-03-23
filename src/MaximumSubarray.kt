
import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main(){
    val value = measureTimedValue {
        val array = arrayOf(-2,1,-3,4,-1,2,1,-5,4)
        maxSubArray(array.toIntArray())
    }
    println(value)
}

fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var maxSum = nums[0]
    val currentArray = IntArray(nums.size)
    currentArray[0] = nums[0]

    for (i in 1 until nums.size) {
        currentArray[i] = max(nums[i], nums[i] + currentArray[i - 1])
        maxSum = max(maxSum, currentArray[i])
    }

    return maxSum
}