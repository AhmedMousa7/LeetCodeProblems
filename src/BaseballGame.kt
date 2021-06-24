import java.util.*

fun main() {
    println(calPoints(arrayOf("5","2","C","D","+")))
}

fun calPoints(ops: Array<String>): Int {
    val stack = Stack<Int>()
    ops.forEach {
        when (it) {
            "C" -> {
                stack.pop()
            }
            "D" -> {
                stack.push(stack.peek() * 2)
            }
            "+" -> {
                val num1 = stack.peek()
                val num2 = stack[stack.size - 2]
                stack.push(num1 + num2)
            }
            else -> {
                stack.push(it.toInt())
            }
        }
    }

    return stack.sum()
}