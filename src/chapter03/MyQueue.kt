package chapter03

/*
    Simple implementation of a queue using a singly linked list with tail pointer.
 */

class MyQueue<T> {
    private var head: LinkedNode<T>? = null
    private var tail: LinkedNode<T>? = null

    fun enqueue(value: T) {
        val newNode = LinkedNode(value)
        if (head == null) {
            head = newNode
        } else {
            tail!!.next = newNode
        }
        tail = newNode
    }

    fun dequeue(): T {
        if (empty()) throw Exception("The queue is empty")

        val result = head!!.value
        head = head!!.next
        if (head == null) tail = null
        return result
    }

    fun empty() = head == null

    private class LinkedNode<T>(val value: T) {
        var next: LinkedNode<T>? = null
    }
}