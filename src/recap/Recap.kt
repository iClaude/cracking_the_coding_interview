package recap

import chapter04.Node

fun createBST(values: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null

    val mid = (end + start) / 2
    return Node(values[mid]).apply {
        left = createBST(values, start, mid - 1)
        right = createBST(values, mid + 1, end)
    }
}

fun main() {
    val values = intArrayOf(3, 5, 9, 11, 15, 18)
    val tree = createBST(values, 0, values.lastIndex)
    println("done")
}