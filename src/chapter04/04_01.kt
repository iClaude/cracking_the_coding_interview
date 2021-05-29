package chapter04

import java.util.*

/*
    Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
    route between two nodes.
 */

fun main() {

    val vertex1 = Vertex(1)
    val vertex2 = Vertex(2)
    val vertex3 = Vertex(3)
    val vertex4 = Vertex(4)
    val vertex5 = Vertex(5)
    val vertex6 = Vertex(6)
    val vertex7 = Vertex(7)
    val vertex8 = Vertex(8)

    val graph = Graph().apply {
        vertices.add(
            vertex1.apply {
                neighbors.add(
                    vertex2.apply {
                        neighbors.add(
                            vertex5.apply {
                                neighbors.add(
                                    vertex6
                                )
                            }
                        )
                    }
                )
                neighbors.add(
                    vertex3.apply {
                        neighbors.add(
                            vertex5
                        )
                    }
                )
                neighbors.add(
                    vertex4.apply {
                        neighbors.add(
                            vertex7.apply {
                                neighbors.add(vertex8)
                            }
                        )
                    }
                )
            }
        )
    }

    println(isThereARoute(vertex6, vertex6))

}

private fun isThereARoute(vertexA: Vertex, vertexB: Vertex): Boolean {
    val queue = LinkedList<Vertex>()
    queue.add(vertexA)

    while (!queue.isEmpty()) {
        val vertex = queue.poll().apply {
            visited = true
        }
        if (vertex == vertexB) return true

        for (neighbor in vertex.neighbors) {
            if (!neighbor.visited) {
                queue.add(neighbor)
            }
        }
    }

    return false
}