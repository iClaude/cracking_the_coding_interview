package chapter02

/* PROBLEM
   2.2 Implement an algorithm to find the nth to last element of a singly linked list.
   ALGORITHM
   [see method nToLastElement()]
   Scan the list with 2 pointers: the second pointer (p2) starts n steps after the first pointer (p1), so it is exactly n nodes
   before. When the first pointer reaches the end of the list, p2 points to the nth to last element of the list.
   Performance: O(n)
*/


fun main() {
    val list1 = SinglyLinkedList<Char>().apply {
        pushBack('a')
        pushBack('b')
        pushBack('c')
        pushBack('d')
        pushBack('e')
    }

    println(list1.nToLastElement(list1, 2)?.key)
}