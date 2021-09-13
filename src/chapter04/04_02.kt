package chapter04

/*
    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
    to create a binary search tree with minimal height.
 */

fun main() {
    val array = intArrayOf(7, 8, 9)
    val tree = createBST(array, 0, array.lastIndex)
    println(tree)
}

fun createBST(values: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null

    val mid = (end + start) / 2
    return Node(values[mid]).apply {
        left = createBST(values, start, mid - 1)
        right = createBST(values, mid + 1, end)
    }
}
