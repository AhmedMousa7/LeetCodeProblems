
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var result = "$`val`, "

        while (next != null){
            result += next?.`val`.toString() + ", "
            next = next?.next
        }
        return result
    }
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    node2.next = node3
    node1.next = node2

    val node10 = ListNode(1)
    val node20 = ListNode(3)
    val node30 = ListNode(4)
    node20.next = node30
    node10.next = node20

    println(mergeTwoLists(node1, node10))
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode(0)
    var temp: ListNode? = result
    var l1T = l1
    var l2T = l2

    while (l1T != null && l2T != null){
        if (l1T.`val` < l2T.`val`) {
            temp?.next = l1T
            l1T = l1T.next
        } else {
            temp?.next = l2T
            l2T = l2T.next
        }
        temp = temp?.next
    }

    temp?.next = l1T ?: l2T

    return result.next
}