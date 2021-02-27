package chapter02

/*  Intersection: Given two (singly) linked lists, determine if the two lists intersect.
    Return the intersecting
    node. Note that the intersection is defined based on reference, not value. That is, if the kth
    node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting. */

fun main() {
    val intersection = LinkedNode(3).apply {
        next = LinkedNode(5).apply {
            next = LinkedNode(8)
        }
    }
    val head1 = LinkedNode(7).apply {
        next = LinkedNode(4).apply {
            next = intersection
        }
    }
    val head2 = LinkedNode(5).apply {
        next = LinkedNode(4).apply {
            next = LinkedNode(2).apply {
                next = LinkedNode(20).apply {
                    next = intersection
                }
            }
        }
    }

    println(getIntersectionWithMap(head1, head2)?.value)
    println(getIntersectionSwapPointers(head1, head2)?.value)
}

private fun getIntersectionWithMap(head1: LinkedNode, head2: LinkedNode): LinkedNode? {
    val nodes = mutableMapOf<LinkedNode, Boolean>()

    var p1: LinkedNode? = head1
    var p2: LinkedNode? = head2
    while (p1 != null || p2 != null) {
        if (p1 != null) {
            val current = nodes.putIfAbsent(p1, true)
            if (current != null) return p1
            p1 = p1.next
        }

        if (p2 != null) {
            val current = nodes.putIfAbsent(p2, true)
            if (current != null) return p2
            p2 = p2.next
        }
    }

    return null
}

private fun getIntersectionSwapPointers(head1: LinkedNode?, head2: LinkedNode?): LinkedNode? {
    var p1 = head1
    var p2 = head2
    var tail1: LinkedNode? = null
    var tail2: LinkedNode? = null

    while (p1 != p2) {
        if (p1?.next == null) {
            tail1 = p1!!
            p1 = head2
        } else {
            p1 = p1.next
        }

        if (p2?.next == null) {
            tail2 = p2!!
            p2 = head1
        } else {
            p2 = p2.next
        }

        if (tail1 != null && tail2 != null && tail1 != tail2) return null
    }

    return p1

}