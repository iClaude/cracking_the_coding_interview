package recap

import java.util.*

fun main() {
    val myStack = StackRecap<Char>().apply {
        push('a')
        push('b')
        println(top())
        push('c')
        println(empty())
        println(pop())
        println(pop())
        println(top())
        println(pop())
        println(empty())
        top()
    }
}

class StackRecap<T> {
    private var head: LinkedNodeRecap<T>? = null

    fun push(value: T) {
        val newNode = LinkedNodeRecap(value).apply {
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

    private class LinkedNodeRecap<T>(val value: T) {
        var next: LinkedNodeRecap<T>? = null
    }
}