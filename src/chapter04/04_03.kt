package chapter04

/*
    4.3 Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */
fun createTree(values: IntArray, start: Int, end: Int): Node? {
    if (start > end) return null

    val index = (start + end) / 2
    return Node(values[index]).apply {
        left = createTree(values, start, index - 1)
        right = createTree(values, index + 1, end)
    }
}

// test
fun main() {
    val values = intArrayOf(0, 1, 2, 3, 4, 5)
    val root = createTree(values, 0, values.lastIndex)
    println(root)
}