import java.util.ArrayDeque

fun main() {
    val nums = arrayOf(1,3,-1,-3,5,3,6,7)
    //val nums = arrayOf(4,-2)
    print(maxSlidingWindow(nums.toIntArray(), 3).toList())
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val n: Int = nums.size
    if (n == 0 || k == 0) {
        return IntArray(0)
    }

    val result = IntArray(n - k + 1) // number of windows
    val win = ArrayDeque<Int>() // stores indices
    for (i in 0 until n) {
        // remove indices that are out of bound
        while (win.size > 0 && win.peekFirst() <= i - k) {
            win.pollFirst()
        }
        // remove indices whose corresponding values are less than nums[i]
        while (win.size > 0 && nums[win.peekLast()] < nums[i]) {
            win.pollLast()
        }
        // add nums[i]
        win.offerLast(i)
        // add to result
        if (i >= k - 1) {
            result[i - k + 1] = nums[win.peekFirst()]
        }
    }

    return result
}