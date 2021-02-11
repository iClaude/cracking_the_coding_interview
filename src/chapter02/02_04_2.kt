package chapter02

/*
  2.4 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
  EXAMPLE
  Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
  Output: 8 -> 0 -> 8

  ALGORITHM 1
  Iterative solution (fun sumIterative())
  Loop over the 2 lists, one node after the other, and sum them, keeping track of the remainders.
  Performance: O(n), n = length of the longest list.

  ALGORITHM 2
  Recursive solution (fun sumRecursive())
  Sum recursively each pair of nodes, keeping track of the remainders. The function updates the result list passed as argument.
  Performance: O(n), n = length of the longest list.
*/

fun sumIterative(list1: SinglyLinkedList<Int>, list2: SinglyLinkedList<Int>)
        : SinglyLinkedList<Int> {
    val result = SinglyLinkedList<Int>()
    var p1 = list1.head
    var p2 = list2.head
    var rem = 0

    while (p1 != null || p2 != null) {
        val sum = ((p1?.key ?: 0) + (p2?.key ?: 0) + rem)
        result.pushBack(sum.rem(10))
        rem = if (sum >= 10) 1 else 0

        p1 = p1?.next
        p2 = p2?.next
    }

    if (rem == 1) result.pushBack(1)

    return result
}

// best solution
fun sumRecursive1(list1: ListNode?, list2: ListNode?, rem: Int): ListNode? {
    val sum = ((list1?.value ?: 0) + (list2?.value ?: 0) + rem)

    return if (list1 == null && list2 == null && rem == 1) {
        ListNode(1)
    } else if (list1 == null && list2 == null && rem == 0) {
        null
    } else {
        ListNode(sum.rem(10)).apply {
            next = sumRecursive1(list1?.next, list2?.next, if (sum >= 10) 1 else 0)
        }
    }
}

data class ListNode(val value: Int) {
    var next: ListNode? = null
}

// a variation of the recursive solution
fun sumRecursive2(node1: Node<Int>?, node2: Node<Int>?, rem: Int, list: SinglyLinkedList<Int>) {
    if (node1 == null && node2 == null) {
        if (rem == 1) list.pushBack(1)
        return
    }

    val digit1 = node1?.key ?: 0
    val digit2 = node2?.key ?: 0
    val sum = (digit1 + digit2 + rem) % 10
    val remNew = if (digit1 + digit2 + rem >= 10) 1 else 0

    list.pushBack(sum)
    sumRecursive2(node1?.next, node2?.next, remNew, list)
}
