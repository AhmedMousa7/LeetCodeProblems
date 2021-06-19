import kotlin.math.max

fun main() {
    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}

fun trap(height: IntArray): Int {
    if (height.size < 3) return 0
    var count = 0
    var lMax = height[0]
    var rMax = height[height.size - 1]
    var i = 1
    var j = height.size - 2
    while (i <= j) {
        if (lMax <= rMax) {
            if (lMax > height[i]) {
                count += lMax - height[i]
            }
            lMax = max(lMax, height[i])
            i++
        } else {
            if (rMax > height[j]) {
                count += rMax - height[j]
            }
            rMax = max(rMax, height[j])
            j--
        }
    }
    return count
}