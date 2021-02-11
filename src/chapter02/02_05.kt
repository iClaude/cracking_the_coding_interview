package chapter02

fun main() {
    val head1 = LinkedNode(2).apply {
        next = LinkedNode(8).apply {
            next = LinkedNode(7)
        }
    }
    val head2 = LinkedNode(1).apply {
        next = LinkedNode(3)
    }

    printList(sumLists(head1, head2))
    println()
    printList(sumListsForwardOrder(head1, head2))

}

private fun sumLists(head1: LinkedNode, head2: LinkedNode): LinkedNode {
    val head = LinkedNode(sum(head1.value, head2.value))
    var rem = remainder(head1.value, head2.value)

    var p = head
    var p1 = head1.next
    var p2 = head2.next

    while (p1 != null || p2 != null) {
        val node = LinkedNode(sum(p1?.value ?: 0, p2?.value ?: 0, rem))
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

private fun sum(vararg nums: Int) =
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

private fun sumListsForwardOrder(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {
    if (node1 == null && node2 == null) {
        return null
    }

    val node = sumListsForwardOrder(node1?.next, node2?.next)

    val mNode = LinkedNode(sum(node1?.value ?: 0, node2?.value ?: 0, remF)).apply {
        next = node
    }
    remF = remainder(node1?.value ?: 0, node2?.value ?: 0, remF)

    return mNode

}

var remF = 0