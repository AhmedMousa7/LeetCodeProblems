import java.math.BigInteger
/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
fun main() {
    val node1 = ListNode(7)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    val node4 = ListNode(3)
    node3.next = node4
    node2.next = node3
    node1.next = node2

    val nodex1 = ListNode(5)
    val nodex2 = ListNode(6)
    val nodex3 = ListNode(4)
    nodex2.next = nodex3
    nodex1.next = nodex2

    print(addTwoNumbers(node1, nodex1))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null
    if (l1 != null && l2 == null) return l1
    if (l1 == null && l2 != null) return l2
    val num1 = l1?.toBigInteger() ?: return null
    val num2 = l2?.toBigInteger() ?: return null
    val sum = num1 + num2

    return sum.toString().toNodeList()
}

fun ListNode.toBigInteger(): BigInteger {
    var node: ListNode? = this
    var number = BigInteger.valueOf(0L)

    while (node != null) {
        number *= BigInteger.valueOf(10)
        number += BigInteger.valueOf(node.`val`.toLong())
        node = node.next
    }

    return number
}

fun String.toNodeList(): ListNode {
    val head = ListNode(this[0].toString().toInt())
    var curr: ListNode? = head
    for (i in 1 until this.length) {
        curr?.next = ListNode(this[i].toString().toInt())
        curr = curr?.next
    }
    return head
}

fun print(head: ListNode?) {
    var curr: ListNode? = head
    while (curr != null) {
        print(curr.`val`.toString() + " -> ")
        curr = curr.next
    }
}