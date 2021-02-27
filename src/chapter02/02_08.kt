package chapter02

/*  Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.
    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
    node, so as to make a loop in the linked list.
    EXAMPLE
    Input:
    Output:
    SOLUTION
    A - > B - > C - > D - > E - > C [the same C as earlier]
    C */

fun main() {
    val startLoop = LinkedNode(1)
    val head = startLoop.apply {
        next = startLoop
    }

    println(getStartOfLoopWithMap(head).value)
    println(getStartOfLoopRunnerTechnique(head).value)
}


private fun getStartOfLoopWithMap(head: LinkedNode): LinkedNode {
    val nodes = mutableMapOf<LinkedNode, Boolean>()
    var p = head
    while (true) {
        if (nodes.containsKey(p)) {
            return p
        }
        nodes[p] = true
        p = p.next!!
    }
}

private fun getStartOfLoopRunnerTechnique(head: LinkedNode): LinkedNode {
    var p1 = head.next
    var p2 = head.next!!.next
    while (p1 != p2) {
        p1 = p1!!.next
        p2 = p2!!.next!!.next
    }

    p1 = head
    while (p1 != p2) {
        p1 = p1!!.next
        p2 = p2!!.next
    }

    return p1!!
}