package chapter03

import java.util.*

/*
    Simple implementation of a stack using a singly linked list.
 */

class MyStack<T> {
    private var head: LinkedNode<T>? = null

    fun push(value: T) {
        val newNode = LinkedNode(value).apply {
            next = head
        }
        head = newNode
    }

    fun top(): T {
        if (empty()) throw EmptyStackException()

        return head!!.value
    }

    fun pop(): T {
        if (empty()) throw EmptyStackException()

        val result = head!!.value
        head = head!!.next
        return result
    }

    fun empty() = head == null

    private class LinkedNode<T>(val value: T) {
        var next: LinkedNode<T>? = null
    }
}