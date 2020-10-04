package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    val tree = Node(7).apply {
        left = Node(6).apply {
            left = Node(4)
            right = Node(3).apply {
                left = Node(88)
            }
        }
        right = Node(5).apply {
            right = Node(8)
        }
    }

    println(isBalanced(tree))
}

class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun isBalanced(tree: Node?) =
        (maxHeight(tree) - minHeight(tree)) <= 1

fun maxHeight(tree: Node?): Int {
    tree ?: return 0
    return 1 + max(maxHeight(tree.left), maxHeight(tree.right))
}

fun minHeight(tree: Node?): Int {
    tree ?: return 0
    return 1 + min(minHeight(tree.left), minHeight(tree.right))
}
