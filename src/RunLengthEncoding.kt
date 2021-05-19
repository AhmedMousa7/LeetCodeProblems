fun main() {
    println(runLengthEncoding("aaacsccssad"))
}

fun runLengthEncoding(inputString: String): String {
    var output = ""
    var counter = 1
    var lastKnowChar: Char? = null

    inputString.forEach { char ->
        if (output.contains(char) && lastKnowChar == char){
            counter++
            val lastChar = output.subSequence(output.length - 2, output.length)
            output = output.removeSuffix(lastChar)
            output += "$counter$char"
        } else {
            counter = 1
            output += "$counter$char"
            lastKnowChar = char
        }
    }

    return output
}