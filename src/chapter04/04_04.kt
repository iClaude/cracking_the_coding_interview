package chapter04

import java.util.*

/*
    Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (i.e.,
    if you have a tree with depth D, you’ll have D linked lists).
 */

fun createLists(tree: Node?): List<LinkedList<Node>>? {
    tree ?: return null

    val result = mutableListOf<LinkedList<Node>>()
    var levelXNodes: LinkedList<Node>? = null

    var currNode = tree
    val queue = LinkedList<Node>().apply {
        add(delimiter)
        add(currNode!!)
        add(delimiter)
    }

    while (!queue.isEmpty()) {
        currNode = queue.poll()
        if (currNode == delimiter) {
            currNode = queue.poll()
            if (currNode == delimiter) continue

            levelXNodes = LinkedList()
            result.add(levelXNodes)
        }

        levelXNodes!!.add(currNode)

        if (currNode.left != null) queue.add(currNode.left!!)
        if (currNode.right != null) queue.add(currNode.right!!)
        if (queue.peek() == delimiter) queue.add(delimiter)
    }

    return result
}

val delimiter = Node(Integer.MIN_VALUE)

// test
fun main() {
    val tree = Node(10).apply {
        left = Node(5).apply {
            left = Node(3)
            right = Node(7).apply {
                left = Node(6)
            }
        }
        right = Node(15).apply {
            left = Node(12)
            right = Node(20).apply {
                left = Node(16)
                right = Node(21)
            }
        }
    }

    val lists = createLists(tree)
    for (list in lists!!) {
        println(list.toString())
    }
}