package chapter02

/*
  2.3 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
  EXAMPLE
  Input: the node ‘c’ from the linked list a->b->c->d->e
  Result: nothing is returned, but the new linked list looks like a->b->d->e

  ALGORITHM
  [see method eraseWithNode]
  Take the node c and set its key to c.next.key and its next pointer to c.next.next.
  This method doesn't work for the last node (tail).
  This algorithm simply changes the content of a node, not the node itself. This way there is no need to update the
  head even if the node to delete is the head (the node stays the same, but its content changes).
  Performance: O(1)
*/

fun main() {
    val list = SinglyLinkedList<Char>()
    val node = list.pushBackWithNode('a')
    list.pushBackWithNode('b')
    list.pushBackWithNode('c')
    list.pushBackWithNode('d')
    list.pushBackWithNode('e')

    list.eraseWithNode(node)
    println(list.toString())

}