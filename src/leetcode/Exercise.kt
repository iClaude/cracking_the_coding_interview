package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    val tree = Node(7).apply {
        left = Node(5)
    }

    println("max height = ${maxHeight(tree)}")
    println("min height = ${minHeight(tree)}")

    println(isBalanced(tree))
}

fun isBalanced(tree: Node) =
        maxHeight(tree) - minHeight(tree) <= 1

fun maxHeight(tree: Node?): Int {
    if (tree == null) return 0
    return 1 + max(maxHeight(tree.left), maxHeight(tree.right))
}

fun minHeight(tree: Node?): Int {
    if (tree == null) return 0
    return 1 + min(minHeight(tree.left), minHeight(tree.right))
}

class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
}