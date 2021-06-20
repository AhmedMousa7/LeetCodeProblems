import java.util.PriorityQueue

class RecentCounter() {
    private val queue = PriorityQueue<Int>()

    // faster than 95.65% - 432 ms
    fun ping(t: Int): Int {
        val range = t - TIME_THRESHOLD
        while (queue.isNotEmpty() && queue.peek() < range) {
            queue.poll()
        }
        queue.add(t)
        return queue.size
    }

    /**
     * First Solution 4544 ms
    fun ping(t: Int): Int {
    val startRange = t - TIME_THRESHOLD
    queue.add(t)
    var counter = 0
    val temp = PriorityQueue<Int>(queue)
    while (temp.isNotEmpty()) {
    if (temp.peek() in startRange..t) {
    counter++
    temp.poll()
    } else {
    queue.remove(temp.poll())
    }
    }
    return counter
    }*/

    companion object {
        private const val TIME_THRESHOLD = 3000
    }
}

fun main() {
    val obj = RecentCounter()
    println(obj.ping(1))
    println(obj.ping(100))
    println(obj.ping(3001))
    println(obj.ping(3002))
}
