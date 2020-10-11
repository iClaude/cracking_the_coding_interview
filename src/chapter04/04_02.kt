package chapter04

import java.util.*

/*
    4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

fun isThereARoute(adjMatrix: Map<Vertex, List<Vertex>>, v: Vertex, end: Vertex): Boolean {
    val queue = LinkedList<Vertex>().apply {
        add(v)
    }
    while (!queue.isEmpty()) {
        val vertex = queue.poll().apply {
            visited = true
        }
        if (vertex == end) return true
        for (connectedVertex in adjMatrix[vertex] ?: error("vertex not in the adjacency matrix")) {
            if (!connectedVertex.visited) {
                queue.add(connectedVertex)
            }
        }
    }
    return false
}

class Vertex(val value: Int) {
    var visited = false
}

fun main() {
    val v1 = Vertex(1)
    val v2 = Vertex(2)
    val v3 = Vertex(3)
    val v5 = Vertex(5)
    val v8 = Vertex(8)
    val v10 = Vertex(10)
    val v11 = Vertex(11)
    val v14 = Vertex(14)
    val v16 = Vertex(16)
    val adjMatrix = mapOf(
            v1 to listOf(v2, v3),
            v2 to listOf(v3),
            v3 to listOf(v5),
            v5 to listOf(v2, v8, v10),
            v8 to listOf(v11),
            v10 to listOf(v8),
            v11 to listOf()
    )

    println(isThereARoute(adjMatrix, v2, v10))
}