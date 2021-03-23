import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main(){
    val value = measureTimedValue {
        intToRoman(65)
    }
    println(value)
}

fun intToRoman(num: Int): String {
    var runningNum = num
    val stringBuilder = StringBuilder()
    for(digit in DIGIT.values()){
        val divs = runningNum / digit.value
        repeat(divs){
            stringBuilder.append(digit.symbol)
        }
        runningNum -= digit.value * divs
        if (runningNum == 0) break
    }
    return stringBuilder.toString()
}

enum class DIGIT(val value: Int, val symbol: String){
    M(1000, "M"),
    CM(900, "CM"),
    D(500, "D"),
    CD(400, "CD"),
    C(100, "C"),
    XC(90, "XC"),
    L(50, "L"),
    XL(40, "XL"),
    X(10, "X"),
    IX(9, "IX"),
    V(5, "V"),
    IV(4, "IV"),
    I(1, "I")
}