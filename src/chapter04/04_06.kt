package chapter04

import java.util.*

/*
    4.6 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid
    storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */

private fun firstCommonAncestor(root: NodeWithParent, node1: NodeWithParent, node2: NodeWithParent): NodeWithParent? {
    val path1 = pathToRoot(node1)
    val path2 = pathToRoot(node2)

    if (path1.empty() || path2.empty()) return null

    var p = root
    while (!path1.empty() && !path2.empty()) {
        val dir1 = path1.pop()
        val dir2 = path2.pop()
        if (dir1 != dir2) break
        if (!path1.empty() && !path2.empty()) {
            p = if (dir1 == -1) p.left!! else p.right!!
        }
    }

    return p
}

private fun pathToRoot(node: NodeWithParent): Stack<Int> {
    val path = Stack<Int>()
    var p = node
    while (p.parent != null) {
        path.push(if (p == p.parent!!.left) -1 else 1)
        p = p.parent!!
    }

    return path
}

