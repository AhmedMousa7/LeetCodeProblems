import kotlin.math.abs

fun main() {
    print(divide(1038925803, -2147483648))
}

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend >= Int.MAX_VALUE && divisor == 1) return Int.MAX_VALUE
    if (dividend >= Int.MAX_VALUE && divisor == -1) return Int.MIN_VALUE
    if (dividend <= Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
    if (dividend <= Int.MIN_VALUE && divisor == 1) return Int.MIN_VALUE
    if (dividend == 0 || divisor == 1) return dividend
    if (dividend == divisor) return 1
    if (dividend > 0 && divisor > 0 && dividend < divisor) return 0
    if (dividend > 0 && divisor < 0 && dividend < abs(divisor)) return 0
    if (dividend < 0 && divisor < 0 && dividend > divisor) return 0
    if (dividend < 0 && divisor > 0 && abs(dividend) < divisor) return 0

    val isNegative = if (dividend < 0 && divisor < 0) false
    else if (dividend < 0) true
    else divisor < 0

    var cDivied = dividend
    var counter = 0
    while (true){
        if (isNegative) {
            cDivied += divisor
            counter--
        } else {
            cDivied -= divisor
            counter++
        }
        if (cDivied < Int.MAX_VALUE && cDivied > Int.MIN_VALUE) {
            if (cDivied == 0 || abs(cDivied) < abs(divisor)) break
        }
    }

    return counter
}
