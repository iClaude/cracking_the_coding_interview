package chapter04

data class NodeWithParent(val data: Int) {
    var parent: NodeWithParent? = null
    var left: NodeWithParent? = null
    var right: NodeWithParent? = null
}