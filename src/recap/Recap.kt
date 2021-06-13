package recap

import chapter02.LinkedNode
import kotlin.math.abs

fun main() {
    val head1 = LinkedNode(1).apply {
        next = LinkedNode(2).apply {
            next = LinkedNode(5)
        }
    }

    val head2 = LinkedNode(7)

    printList(sumListsForwardOrder(head1, head2))
}

private fun sumListsIterative(head1: LinkedNode, head2: LinkedNode): LinkedNode {
    val head = LinkedNode(sum(head1, head2))
    var rem = rem(head1, head2)

    var p1: LinkedNode? = head1.next
    var p2: LinkedNode? = head2.next
    var curr: LinkedNode = head
    while (p1 != null || p2 != null) {
        val node = LinkedNode(sum(p1, p2, rem))
        rem = rem(p1, p2, rem)
        curr.next = node
        curr = node

        p1 = p1?.next
        p2 = p2?.next
    }

    if (rem == 1) {
        curr.next = LinkedNode(1)
    }

    return head
}

private fun sumListsRecursive(node1: LinkedNode?, node2: LinkedNode?, rem: Int = 0): LinkedNode? {
    if (node1 == null && node2 == null) {
        return if (rem == 0) null
        else LinkedNode(1)

    }

    return LinkedNode(sum(node1, node2, rem)).apply {
        next = sumListsRecursive(node1?.next, node2?.next, rem(node1, node2, rem))
    }
}

var remF = 0

private fun sumListsForwardOrder(head1: LinkedNode, head2: LinkedNode): LinkedNode {
    val len1 = getListLength(head1)
    val len2 = getListLength(head2)

    var headSum: LinkedNode? = null
    if (len1 != len2) {
        val newHead = LinkedNode(0)
        var cur = newHead
        repeat(abs(len1 - len2) - 1) {
            val node = LinkedNode(0)
            cur.next = node
            cur = node
        }

        if (len1 < len2) {
            cur.next = head1
            headSum = sumListsForward(newHead, head2)
        } else {
            cur.next = head2
            headSum = sumListsForward(head1, newHead)
        }
    } else {
        headSum = sumListsForward(head1, head2)
    }

    return if (remF == 0) {
        headSum!!
    } else {
        LinkedNode(1).apply {
            next = headSum
        }
    }
}

private fun sumListsForward(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {
    if (node1 == null && node2 == null) {
        return null
    }

    val sum = LinkedNode(-1).apply {
        next = sumListsForward(node1?.next, node2?.next)
    }
    sum.value = sum(node1, node2, remF)
    remF = rem(node1, node2, remF)

    return sum
}

private fun sum(node1: LinkedNode?, node2: LinkedNode?, rem: Int = 0) =
    ((node1?.value ?: 0) + (node2?.value ?: 0) + rem) % 10

private fun rem(node1: LinkedNode?, node2: LinkedNode?, rem: Int = 0) =
    if (((node1?.value ?: 0) + (node2?.value ?: 0) + rem) >= 10) 1 else 0

private fun getListLength(head: LinkedNode): Int {
    var len = 0
    var p: LinkedNode? = head
    while (p != null) {
        len++
        p = p.next
    }

    return len
}

private fun printList(head: LinkedNode?) {
    var p: LinkedNode? = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}