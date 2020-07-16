package chapter03

/*
    Simple implementation of a stack using a singly linked list.
 */

class Stack<T> {
    var head: Node<T>? = null

    fun empty() = head == null

    fun push(key: T) {
        val newNode = Node(key).apply {
            next = head
        }
        head = newNode
    }

    fun top(): T? = head?.key

    fun pop(): T? {
        val result = head?.key
        head = head?.next
        return result
    }

    data class Node<T>(var key: T) {
        var next: Node<T>? = null
    }
}