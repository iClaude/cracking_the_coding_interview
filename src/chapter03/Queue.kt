package chapter03

/*
    Simple implementation of a queue using a singly linked list with tail pointer.
 */

class Queue<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    fun empty() = head == null

    fun enqueue(key: T) {
        val newNode = Node(key).apply {
            next = null
        }
        tail?.next = newNode
        tail = newNode
        if (head == null) head = newNode
    }

    fun dequeue(): T? {
        val result = head?.key
        if (head == null) tail = null
        head = head?.next
        return result
    }

    data class Node<T>(var key: T) {
        var next: Node<T>? = null
    }
}