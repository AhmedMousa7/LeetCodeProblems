fun main(){
    println(convert("A", 7))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1 || numRows > s.length) return s
    var result = ""
    for (i in 0 until numRows){
        val stepUp = i * 2
        val stepDown = (numRows - i - 1) * 2
        var j = i
        var isDown = getIsDown(stepUp, stepDown)
        result += s[i]
        while (j < s.length){
            val newIndex = if (isDown){
                j + stepDown
            }else {
                j + stepUp
            }
            if (newIndex < s.length){
                result += s[newIndex]
            }

            isDown = if (stepDown != 0 && stepUp != 0){
                !isDown
            }else {
                getIsDown(stepUp, stepDown)
            }

            val jUp = j + stepUp
            val jDown = j + stepDown
            j =  if (isDown && jDown > s.length){
                s.length
            } else if (!isDown && jUp > s.length){
                s.length
            } else{
                newIndex
            }
        }
    }

    return result
}

private fun getIsDown(stepUp: Int, stepDown: Int): Boolean{
    return when {
        stepUp == 0 -> {
            true
        }
        stepDown == 0 -> {
            false
        }
        else -> {
            true
        }
    }
}