package chapter02

/*  Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    that node.
    EXAMPLE
    lnput:the node c from the linked list a->b->c->d->e->f
    Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f */

fun main() {
    val nodeToDelete = LinkedNode(2)

    val head = LinkedNode(1).apply {
        next = nodeToDelete.apply {
            next = LinkedNode(7).apply {
                next = LinkedNode(8).apply {
                    next = LinkedNode(5).apply {
                        next = LinkedNode(3)
                    }
                }
            }
        }
    }

    println(deleteMiddleNode(nodeToDelete))
    printList(head)
}

private fun deleteMiddleNode(node: LinkedNode?): Boolean {
    if (node?.next == null) {
        return false
    }

    node.apply {
        value = next!!.value
        next = next!!.next
    }
    return true
}

private fun printList(head: LinkedNode) {
    var p: LinkedNode? = head
    while (p != null) {
        print("${p.value} - ")
        p = p.next
    }
}