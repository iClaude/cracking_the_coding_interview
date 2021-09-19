package chapter04

import java.util.*

/*
    List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
    at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

fun main() {
    val tree = Node(1).apply {
        left = Node(2).apply {
            left = Node(4).apply {
                left = Node(8)
                right = Node(9)
            }
            right = Node(5)
        }
        right = Node(3).apply {
            left = Node(6)
            right = Node(7)
        }
    }

    val listOfDepths1 = recap.createListOfDepthsBFS(tree)
    createListOfDepthsDFS(tree, 0)
    println("end")
}

// based on BFS algorithm
fun createListOfDepthsBFS(root: Node): List<LinkedList<Node>> {
    val result: MutableList<LinkedList<Node>> = mutableListOf()
    result.add(LinkedList<Node>().apply { add(root) })

    while (result[result.lastIndex].size > 0) { // check condition to exit
        val list = LinkedList<Node>()
        for (node in result[result.lastIndex]) {
            node.left?.let { list.add(it) }
            node.right?.let { list.add(it) }
        }
        result.add(list)
    }

    result.removeAt(result.lastIndex)
    return result
}

// based on DFS algorithm
val resultDFS: MutableList<LinkedList<Node>> = mutableListOf()

fun createListOfDepthsDFS(node: Node?, level: Int) {
    node ?: return

    if (level !in resultDFS.indices) {
        resultDFS.add(LinkedList())
    }
    resultDFS[level].add(node)

    createListOfDepthsDFS(node.left, level + 1)
    createListOfDepthsDFS(node.right, level + 1)
}