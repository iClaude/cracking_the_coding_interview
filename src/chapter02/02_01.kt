package chapter02

/*
  PROBLEM
  2.1 Write code to remove duplicates from an unsorted linked list.

  ALGORITHM 1 (with additional buffer)
  [see the method removeDuplicates()]
  Scan the list and add each new node in a control map.
  If a node is included in the map, skip it and update the pointer accordingly, otherwise add it to the map.
  Performance: O(n). An additional buffer containing each element of the list is used (a map).

  ALGORITHM 2 (without additional buffer)
  [see the method removeDuplicatesWithoutBufferA()]
  Take each node and scan the rest of the list deleting other occurrences of the same node.

  ALGORITHM 3 (without additional buffer)
  [see the method removeDuplicatesWithoutBufferB()]
  Take each node X, scan the list from the beginning and when you find another node with the same key,
  delete X, exiting the inner loop.
  This algorithm is more efficient than algorithm 2 because when you find a duplicate you can delete the current
  node and stop scanning the following nodes.
*/

fun main() {
    val list = SinglyLinkedList<Char>().apply {
        pushBack('a')
        pushBack('a')
        pushBack('b')
        pushBack('b')
        pushBack('c')


    }
    list.removeDuplicates()
    println(list.toString())
}
