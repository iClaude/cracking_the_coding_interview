package chapter04

import kotlin.math.max
import kotlin.math.min

/*
    4.1 Implement a function to check if a tree is balanced. For the purposes of this question, a balanced tree is
    defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
 */

// this is equal to the height algorithm
fun maxDepth(tree: Node?): Int {
    if (tree == null) return 0

    return 1 + max(maxDepth(tree.left), maxDepth(tree.right))
}

// modification of the height algorithm to return the min distance between root and any leaf
fun minDepth(tree: Node?): Int {
    if (tree == null) return 0

    return 1 + min(maxDepth(tree.left), maxDepth(tree.right))
}

// test
fun main() {
    val tree = Node(5).apply {
        left = Node(3).apply {
            left = Node(2)
        }
        right = Node(8)
    }

    println("balanced? ${maxDepth(tree) - minDepth(tree) <= 1}")
}