package chapter04

import kotlin.math.abs
import kotlin.math.max

/*
    Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
    this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
    node never differ by more than one.
*/

var count = 0
var count2 = 0

fun main() {
    val tree = Node(7).apply {
        left = Node(5).apply {
            left = Node(6)
            right = Node(4).apply {
                right = Node(5).apply {
                    right = Node(6)
                }
            }
        }
        right = Node(9).apply {
            left = Node(8).apply {
                right = Node(7).apply {
                    right = Node(5)
                }
            }
        }
    }

    println("is balanced? ${isBalanced(tree)}")
    println("is balanced2? ${isBalanced2(tree)}")
    println("count = $count")
    println("count2 = $count2")

}

private fun isBalanced(tree: Node?): Boolean {
    count++
    tree ?: return true

    val leftHeight = height(tree.left)
    val rightHeight = height(tree.right)

    return if (abs(leftHeight - rightHeight) > 1) {
        false
    } else {
        isBalanced(tree.left) && isBalanced(tree.right)
    }
}


private fun height(tree: Node?): Int {
    count++
    tree ?: return 0

    return 1 + max(height(tree.left), height(tree.right))
}


private fun checkHeight(tree: Node?): Int {
    count2++
    tree ?: return 0

    val leftHeight = checkHeight(tree.left)
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE

    val rightHeight = checkHeight(tree.right)
    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE

    val diffHeight = abs(leftHeight - rightHeight)
    if (diffHeight > 1) {
        return Integer.MIN_VALUE
    } else {
        return 1 + max(leftHeight, rightHeight)
    }
}

private fun isBalanced2(tree: Node?) =
    checkHeight(tree) != Integer.MIN_VALUE
