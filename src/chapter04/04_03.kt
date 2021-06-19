package chapter04

import chapter02.LinkedNode
import chapter02.SinglyLinkedList
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

    val resultLists = listOfDepthsBFS2(tree)
    for (list in resultLists!!) {
        println(list)
    }
}

// based on BFS algorithm
private fun listOfDepthsBFS2(tree: Node?): List<LinkedList<Node>>? {
    tree ?: return null

    val result = mutableListOf<LinkedList<Node>>()
    var currList = LinkedList<Node>().apply {
        add(tree)
    }
    result.add(currList)

    while (!currList.isEmpty()) {
        val newList = LinkedList<Node>()
        for (node in currList) {
            if (node.left != null) newList.add(node.left!!)
            if (node.right != null) newList.add(node.right!!)
        }
        result.add(newList)

        currList = newList
    }

    return result
}

//region based on BFS: stores level in each node of the tree
data class TreeNodeWithDepth(val data: Int) {
    var left: TreeNodeWithDepth? = null
    var right: TreeNodeWithDepth? = null
    var level = 0
}

private fun listOfDepthsBFS1(tree: TreeNodeWithDepth?): List<LinkedNode>? {
    tree ?: return null

    val resultList = mutableListOf<LinkedNode>()

    var progrDepth = 0
    val queue = LinkedList<TreeNodeWithDepth>().apply {
        add(tree.apply {
            level = 1
        })
    }
    var currListNode: LinkedNode? = null

    while (queue.isNotEmpty()) {
        val treeNode = queue.poll()

        val newListNode = LinkedNode(treeNode.data)
        if (treeNode.level > progrDepth) {
            resultList.add(newListNode)
            progrDepth++
        } else {
            currListNode?.next = newListNode
        }
        currListNode = newListNode

        if (treeNode.left != null) {
            queue.add(treeNode.left!!.apply {
                level = progrDepth + 1
            })
        }
        if (treeNode.right != null) {
            queue.add(treeNode.right!!.apply {
                level = progrDepth + 1
            })
        }
    }

    return resultList
}
//endregion

// based on DFS algorithm
private fun listOfDepthsDFS(tree: Node?, level: Int, resultLists: MutableList<SinglyLinkedList<Node>>) {
    tree ?: return

    if (resultLists.size - 1 < level) {
        resultLists.add(SinglyLinkedList<Node>().apply {
            pushBack(tree)
        })
    } else {
        resultLists[level].pushBack(tree)
    }

    listOfDepthsDFS(tree.left, level + 1, resultLists)
    listOfDepthsDFS(tree.right, level + 1, resultLists)
}