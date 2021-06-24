
fun main() {
    println(makeGood("abBAcC"))
}

fun makeGood(s: String): String {
    if (s.isEmpty() || s.length == 1) return s
    var str = s[0].toString()
    for (i in 1 until s.length) {
        val current = s[i]
        val prev = if (str.isNotEmpty()) str[str.lastIndex] else '\u0000'
        if (prev != current && prev.equals(current, ignoreCase = true)) {
            str = str.removeSuffix(prev.toString())
        } else {
            str += current.toString()
        }
    }

    return str
}