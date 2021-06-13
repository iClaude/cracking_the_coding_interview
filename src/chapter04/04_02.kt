package chapter04

/*
    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
    to create a binary search tree with minimal height.
 */

fun main() {
    val array = intArrayOf(7, 8, 9)
    val tree = createTree(array, 0, array.lastIndex)
    println(tree)
}

private fun createTree(array: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null

    val pos = start + (end - start) / 2
    return Node(array[pos]).apply {
        left = createTree(array, start, pos - 1)
        right = createTree(array, pos + 1, end)
    }

}
