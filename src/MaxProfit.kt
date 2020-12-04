import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main(){
    val (value, duration) = measureTimedValue {
        maxProfit(arrayOf(3,3,5,0,0,3,1,4).toIntArray())
    }
    println(value)
    println(duration)
}

fun maxProfit(prices: IntArray): Int {
    var minprice = Int.MAX_VALUE
    var maxprofit = 0
    for (i in prices.indices) {
        if (prices[i] < minprice)
            minprice = prices[i]
        else if (prices[i] - minprice > maxprofit)
            maxprofit = prices[i] - minprice
    }
    return maxprofit
}