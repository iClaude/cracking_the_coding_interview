package chapter02

/* Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.*/

fun main() {
    val head = LinkedNode(1).apply {
        next = LinkedNode(2).apply {
            next = LinkedNode(7).apply {
                next = LinkedNode(8).apply {
                    next = LinkedNode(5).apply {
                        next = LinkedNode(3)
                    }
                }
            }
        }
    }

    val k = 3

    println("${k}th to last")
    println("non recursive solution: ${findKthToLast(head, k)?.value}")
    println("recursive solution: ${findKthToLastRecursive(head, k)?.value}")

}

private fun findKthToLast(head: LinkedNode, k: Int): LinkedNode? {
    var p1: LinkedNode? = head
    var p2: LinkedNode? = head

    repeat(k) {
        p2 = p2?.next
        if (p2 == null) return null
    }

    while (p2?.next != null) {
        p2 = p2?.next
        p1 = p1?.next
    }

    return p1
}

private fun findKthToLastRecursive(node: LinkedNode?, k: Int): LinkedNode? {
    // code1: performed only in the 1st recursive traverse, until base case (included)
    if (node == null) {
        // base case: performed only once
        return null
    }

    val mNode = findKthToLastRecursive(node.next, k) // recursive call: mNode == base case at the beginning, then what is returned after this line
    // after base case: performed only in the returning recursive traverse
    count++
    if (count == k) {
        return node
    }

    return mNode
}

var count = -1 // do not consider base case (node null)
