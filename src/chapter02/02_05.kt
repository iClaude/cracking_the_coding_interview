package chapter02

import kotlin.math.abs

/*
    Sum Lists: You have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE
    Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
    Output: 2 -> 1 -> 9. That is, 912.
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
    EXAMPLE
    lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    Output: 9 - > 1 -> 2. That is, 912.
 */
fun main() {
    val head1 = LinkedNode(3).apply {
        next = LinkedNode(8).apply {
            next = LinkedNode(5)
        }
    }
    val head2 = LinkedNode(1).apply {
        next = LinkedNode(7)
    }


    printList(sumListsForwardOder(head1, head2))

}

// reverse order: iterative solution
private fun sumLists(head1: LinkedNode, head2: LinkedNode): LinkedNode {
    val head = LinkedNode(sumLastDigit(head1.value, head2.value))
    var rem = remainder(head1.value, head2.value)

    var p = head
    var p1 = head1.next
    var p2 = head2.next

    while (p1 != null || p2 != null) {
        val node = LinkedNode(sumLastDigit(p1?.value ?: 0, p2?.value ?: 0, rem))
        rem = remainder(p1?.value ?: 0, p2?.value ?: 0, rem)
        p.next = node
        p = node

        p1 = p1?.next
        p2 = p2?.next
    }

    if (rem == 1) {
        p.next = LinkedNode(1)
    }

    return head
}

// forward order: recursive solution
private fun sumListsForwardOder(head1: LinkedNode, head2: LinkedNode): LinkedNode? {
    var head = when (val diffLen = getListLength(head1) - getListLength(head2)) {
        0 -> sumNormalizedLists(head1, head2)
        in 0..Integer.MAX_VALUE -> sumNormalizedLists(head1, normalizeList(head2, diffLen))
        else -> sumNormalizedLists(normalizeList(head1, abs(diffLen)), head2)
    }

    if (remF == 1) {
        val newNode = LinkedNode(1).apply {
            next = head
        }
        head = newNode
    }

    return head
}

private fun sumNormalizedLists(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {
    if (node1 == null && node2 == null) {
        return null
    }

    val node = sumNormalizedLists(node1?.next, node2?.next)

    val mNode = LinkedNode(sumLastDigit(node1!!.value, node2!!.value, remF)).apply {
        next = node
    }
    remF = remainder(node1.value, node2.value, remF)

    return mNode
}

var remF = 0

private fun getListLength(head: LinkedNode): Int {
    var len = 0
    var p: LinkedNode? = head
    while (p != null) {
        len++
        p = p.next
    }

    return len
}

private fun normalizeList(head: LinkedNode, num: Int): LinkedNode {
    var mHead: LinkedNode = head
    var newNode: LinkedNode?
    repeat(num) {
        newNode = LinkedNode(0).apply {
            next = mHead
        }
        mHead = newNode as LinkedNode
    }

    return mHead
}

private fun sumLastDigit(vararg nums: Int) =
        nums.sum() % 10

private fun remainder(vararg nums: Int) =
        if (nums.sum() >= 10) 1 else 0

private fun printList(head: LinkedNode?) {
    var p: LinkedNode? = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}