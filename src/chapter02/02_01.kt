package chapter02

/*  Remove Dups! Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?  */

fun main() {
    val head = LinkedNode(1).apply {
        next = LinkedNode(2)
    }
    removeDuplicates(head)
    printList(head)

    println()
    val head2 = LinkedNode(1).apply {
        next = LinkedNode(2)
    }
    removeDuplicatesWithoutBuffer(head2)
    printList(head2)
}

class LinkedNode(val value: Int) {
    var next: LinkedNode? = null
}

private fun removeDuplicates(head: LinkedNode) {
    val occurrences = mutableMapOf(head.value to true)

    var p1: LinkedNode? = head
    var p2: LinkedNode? = head.next
    while (p2 != null) {
        if (!occurrences.contains(p2.value)) {
            occurrences[p2.value] = true
            p1?.next = p2
            p1 = p1?.next
        }
        p2 = p2.next
    }
    p1?.next = p2
}

private fun removeDuplicatesWithoutBuffer(head: LinkedNode) {
    var pPrev = head
    var p = head.next
    while (p != null) {
        if (isDuplicate(head, p)) {
            pPrev.next = findNext(p)
            p = pPrev.next
        } else {
            pPrev = p
            p = p.next
        }
    }
}

private fun isDuplicate(head: LinkedNode, currentNode: LinkedNode): Boolean {
    var p = head
    while (p != currentNode) {
        if (p.value == currentNode.value) return true
        p = p.next!!
    }
    return false
}

private fun findNext(currentNode: LinkedNode): LinkedNode? {
    var p: LinkedNode? = currentNode.next
    while (p?.value == currentNode.value) {
        p = p.next
    }
    return p
}

private fun printList(head: LinkedNode) {
    var p: LinkedNode? = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}