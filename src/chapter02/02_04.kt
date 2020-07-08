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

fun main() {
    val list1 = SinglyLinkedList<Int>().apply {
        pushBack(7)
        pushBack(8)
        pushBack(9)
    }
    val list2 = SinglyLinkedList<Int>().apply {
        pushBack(1)
        pushBack(5)
        pushBack(7)
    }
    println(sumIterative(list1, list2))

}

fun sumIterative(list1: SinglyLinkedList<Int>, list2: SinglyLinkedList<Int>)
        : SinglyLinkedList<Int> {
    val result = SinglyLinkedList<Int>()
    var p1 = list1.head
    var p2 = list2.head

    var rem = 0
    while (p1 != null || p2 != null) {
        val digit1 = p1?.key ?: 0
        val digit2 = p2?.key ?: 0
        val sum = (digit1 + digit2 + rem) % 10
        rem = if (digit1 + digit2 + rem >= 10) 1 else 0

        result.pushBack(sum)
        p1 = p1?.next
        p2 = p2?.next
    }
    if (rem == 1) result.pushBack(1)

    return result
}

fun sumRecursive(node1: Node<Int>?, node2: Node<Int>?, rem: Int, list: SinglyLinkedList<Int>) {
    if (node1 == null && node2 == null) {
        if (rem == 1) list.pushBack(1)
        return
    }

    val digit1 = node1?.key ?: 0
    val digit2 = node2?.key ?: 0
    val sum = (digit1 + digit2 + rem) % 10
    val remNew = if (digit1 + digit2 + rem >= 10) 1 else 0

    list.pushBack(sum)
    sumRecursive(node1?.next, node2?.next, remNew, list)
}