import java.util.Stack

fun main() {
    println(nextGreaterElement(intArrayOf(4,1,2),  intArrayOf(1,3,4,2)))
}

/**
 * Second Solution Runtime 188 ms
 * faster than 66.67% of Kotlin submissions
 */
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()
    nums2.forEach { num ->
        while (stack.isNotEmpty() && stack.peek() < num) {
            map[stack.pop()] = num
        }
        stack.push(num)
    }
    val result = IntArray(nums1.size) { -1 }
    nums1.forEachIndexed { index, num ->
        result[index] = map[num] ?: -1
    }
    return result
}

/**
*
 * My first Solution Runtime 216 ms
 *
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val result = IntArray(nums1.size) { -1 }
    nums1.forEachIndexed { i, num ->
        val index = nums2.indexOf(num)
        if (index < nums2.size - 1){
            val nextIndex = index + 1
            for (j in nextIndex until nums2.size) {
                if (nums2[j] > num) {
                    result[i] = nums2[j]
                    break
                }
            }
        }
    }
    return result
}*/
