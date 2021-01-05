package leetcode

fun main() {
    val head = ListNode(2).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(2).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(7)
                        }
                    }
                }
            }
        }
    }

    removeDuplicates(head)
    printList(head)
}

private fun printList(head: ListNode?) {
    var p = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}

private var occurrences = mutableMapOf<Int, Boolean>()

private fun removeDuplicates(head: ListNode?) {
    var p1: ListNode? = head ?: return
    occurrences[p1!!.value] = true

    while (p1 != null) {
        p1.next = findNextNode(p1)
        p1 = p1.next
    }
}

private fun findNextNode(node: ListNode): ListNode? {
    var p = node.next
    while (p != null && occurrences.contains(p.value)) {
        p = p.next
    }
    if (p != null) {
        occurrences[p.value] = true
    }
    return p
}


private class ListNode(val value: Int) {
    var next: ListNode? = null
}