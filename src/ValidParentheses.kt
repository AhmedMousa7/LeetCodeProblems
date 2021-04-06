fun main() {
    print(isValid("([)]"))
}

fun isValid(s: String): Boolean {
    val parentheses = mapOf('(' to ')', '[' to ']', '{' to '}')
    var open = 0
    val openIndices = mutableListOf<Int>()

    s.forEachIndexed { index, c ->
        if (c == '(' || c == '{' || c == '['){
            open++
            openIndices.add(index)
        } else {
            if (openIndices.isNotEmpty()) {
                val lastIndex = openIndices[openIndices.lastIndex]
                val lastOpen = s[lastIndex]
                val close = parentheses[lastOpen]
                if (c == close) {
                    open--
                    openIndices.removeAt(openIndices.lastIndex)
                } else {
                    return false
                }
            } else {
                return false
            }
        }
    }

    return open == 0
}