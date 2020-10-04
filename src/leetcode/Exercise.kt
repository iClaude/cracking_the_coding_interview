package leetcode

fun main() {
    val list = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5).apply {
                next = ListNode(66).apply {
                    next = ListNode(7).apply {
                        next = ListNode(10)
                    }
                }
            }
        }
    }

    println(findNToLast(list, 3)?.value)
}

class ListNode(val value: Int) {
    var next: ListNode? = null
}

fun findNToLast(list: ListNode, n: Int): ListNode? {
    var p1: ListNode? = list
    var p2: ListNode? = list
    for (i in 1..n) {
        p2 = p2?.next
        p2 ?: return null
    }

    while (p2?.next != null) {
        p2 = p2.next
        p1 = p1!!.next
    }

    return p1
}