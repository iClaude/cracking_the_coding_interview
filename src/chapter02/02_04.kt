package chapter02

/*  Partition: Write code to partition a linked list around a value x, such that all nodes less
    than x come before all nodes greater than or equal to x. If x is contained within the list,
    the values of x only need to be after the elements less than x (see below). The partition
    element x can appear anywhere in the "right partition"; it does not need to appear between
    the left and right partitions.
    EXAMPLE
    Input:
    Output:
    3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
    3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 */

fun main() {
    val x = 5
    val head = LinkedNode(3).apply {
        next = LinkedNode(5).apply {
            next = LinkedNode(8).apply {
                next = LinkedNode(5).apply {
                    next = LinkedNode(10).apply {
                        next = LinkedNode(2).apply {
                            next = LinkedNode(1)
                        }
                    }
                }
            }
        }
    }

    printList(head)
    println()
    partitionList(head, x)
    printList(head)
}

private fun partitionList(head: LinkedNode, x: Int) {
    var p1 = head
    while (p1.value < x && p1.next != null) {
        p1 = p1.next!!
    }
    if (p1.next == null) return

    var p2: LinkedNode? = p1.next
    while (p2 != null) {
        if (p2.value < x) {
            val tmp = p1.value
            p1.value = p2.value
            p2.value = tmp

            p1 = p1.next!!
        }
        p2 = p2.next
    }
}

private fun printList(head: LinkedNode) {
    var p: LinkedNode? = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}