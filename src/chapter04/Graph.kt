package chapter04

//region Graph represented with an adjacency list.
class Graph {
    val vertices = mutableListOf<Vertex>()
}

class Vertex(val value: Int) {
    val neighbors = mutableListOf<Vertex>()
    var visited = false
}
//endregion