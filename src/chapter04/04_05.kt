package chapter04

/*
    4.5 Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree
    where each node has a link to its parent.
 */

fun findSuccessor(node: NodeWithParent): NodeWithParent? {
    return if (node.right != null) {
        findLeftDescendant(node.right!!)
    } else {
        findRightAncestor(node)
    }
}

fun findLeftDescendant(node: NodeWithParent): NodeWithParent {
    return if (node.left == null) {
        node
    } else {
        findLeftDescendant(node.left!!)
    }
}

fun findRightAncestor(node: NodeWithParent): NodeWithParent? {
    return when {
        node == node.parent?.left -> {
            node.parent
        }
        node.parent == null -> {
            null
        }
        else -> {
            findRightAncestor(node.parent!!)
        }
    }
}

// test
fun main() {
    val startNode = NodeWithParent(6)

    val tree = NodeWithParent(10).apply node10@{
        left = NodeWithParent(5).apply node5@{
            parent = this@node10
            left = NodeWithParent(3).apply {
                parent = this@node5
            }
            right = NodeWithParent(7).apply node7@{
                parent = this@node5
                left = startNode.apply {
                    parent = this@node7
                }
            }
        }
        right = NodeWithParent(15).apply node15@{
            parent = this@node10
            left = NodeWithParent(12).apply {
                parent = this@node15
            }
            right = NodeWithParent(20).apply node20@{
                parent = this@node15
                left = NodeWithParent(16).apply {
                    parent = this@node20
                }
                right = NodeWithParent(21).apply {
                    parent = this@node20
                }
            }
        }
    }

    println(findSuccessor(startNode)?.data)
}