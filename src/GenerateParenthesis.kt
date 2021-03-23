fun main() {
    print(generateParenthesis(2))
}

val results = mutableListOf<String>()

fun generateParenthesis(n: Int): List<String> {
    combin(charArrayOf(), n, n)
    return results
}

fun combin(str:CharArray, left: Int, right: Int) {

    if (left == 0 && right == 0) {
        results.add(String(str))
        return
    }

    if (left <= right && left != 0)
        combin(str.plus('('), left - 1, right)

    if (right != 0)
        combin(str.plus(')'), left, right - 1)
}

