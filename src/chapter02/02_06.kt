package chapter02

import java.util.*


/* Palindrome: Implement a function to check if a linked list is a palindrome. */

fun main() {
    val head = LinkedNode(7).apply {
        next = LinkedNode(1).apply {
            next = LinkedNode(1).apply {
                next = LinkedNode(7)
            }
        }
    }

    println(isPalindrome1(head))
    println(isPalindrome2(head))
    println(isPalindrome3(head))
}

//region Recursive solution: using a queue
private fun isPalindrome1(head: LinkedNode): Boolean {
    val queue = LinkedList<Int>()
    checkPalindrome(head, queue)
    return queue.isEmpty()
}

private fun checkPalindrome(node: LinkedNode?, queue: LinkedList<Int>): LinkedNode? {
    if (node != null) {
        queue.add(node.value)
    } else {
        return null
    }

    checkPalindrome(node.next, queue)
    if (queue.peek() == node.value) {
        queue.poll()
    }

    return node
}
//endregion

//region Iterative solution: reversing the linked list
private fun isPalindrome2(head: LinkedNode): Boolean {
    val head2 = reverseList(head)
    return areListsEqual(head, head2)
}

private fun reverseList(head: LinkedNode): LinkedNode? {
    var head2: LinkedNode? = null
    var p: LinkedNode? = head
    while (p != null) {
        val node = LinkedNode(p.value).apply {
            next = head2
        }
        head2 = node
        p = p.next
    }

    return head2
}

private fun areListsEqual(head1: LinkedNode?, head2: LinkedNode?): Boolean {
    var p1: LinkedNode? = head1
    var p2: LinkedNode? = head2
    while (p1 != null && p2 != null) {
        if (p1.value != p2.value) return false
        p1 = p1.next
        p2 = p2.next
    }
    return (p1 == null && p2 == null)
}
//endregion

//region Iterative solution: using a stack
private fun isPalindrome3(head: LinkedNode): Boolean {
    val stack = Stack<Int>()
    var slow: LinkedNode? = head
    var fast: LinkedNode? = head
    while (fast != null) {
        stack.push(slow?.value)

        if (fast.next != null) slow = slow?.next
        fast = fast.next?.next
    }

    while (slow != null) {
        if (stack.peek() == slow.value) {
            stack.pop()
        } else {
            return false
        }
        slow = slow.next
    }

    return stack.isEmpty()
}
//endregion