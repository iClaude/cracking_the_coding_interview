package chapter02

/*
  2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
  DEFINITION
  Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
  EXAMPLE
  input: A -> B -> C -> D -> E -> C [the same C as earlier]
  output: C

  ALGORITHM (function findLoopBegin())
  Use 2 pointers: p1 moves one node at a time, p2 moves twice as fast (2 nodes at a time). Let them scan the list. The 2 pointers will meet at
  some point at a specific position: the distance between this position and the beginning of the pool is exactly the same as the distance
  between the head of the list and the beginning of the loop.
  Now use 2 pointers, p1 starting from the found position, and p3 starting from the head, and move them at the same speed. They will meet
  exactly at the beginning of the loop.
  Performance: O(n)
*/

fun main() {
    val list = SinglyLinkedList<Char>()
    list.pushBack('a')
    list.pushBack('b')
    val node1 = list.pushBackWithNode('c')
    list.pushBack('d')
    val node2 = list.pushBackWithNode('e')
    node2.next = node1

    println(findLoopBegin(list).key)
}

fun <T> findLoopBegin(list: SinglyLinkedList<T>): Node<T> {
    var p1 = list.head!!.next!!
    var p2 = list.head!!.next!!.next!!
    while (p1 != p2) {
        p1 = p1.next!!
        p2 = p2.next!!.next!!
    }

    var p3 = list.head!!
    while (p1 != p3) {
        p1 = p1.next!!
        p3 = p3.next!!
    }

    return p1
}