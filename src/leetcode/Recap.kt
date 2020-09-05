package leetcode

import java.util.*

fun main() {
    val myQueue = MyQueue<Int>().apply {
        println(empty())
        enqueue(1)
        enqueue(2)
        enqueue(3)
        enqueue(4)
        println(empty())
        println(dequeue())
        enqueue(5)
        enqueue(6)
        println(dequeue())
        println(dequeue())
        println(dequeue())
        println(dequeue())
        println(dequeue())
        println(empty())
        println(dequeue())

    }
}

class MyQueue<T> {
    private val stackEnqueue = Stack<T>()
    private val stackDequeue = Stack<T>()

    fun empty() = stackEnqueue.empty() && stackDequeue.empty()

    fun enqueue(element: T) {
        stackEnqueue.push(element)
    }

    fun dequeue(): T {
        if (empty()) throw EmptyStackException()

        if (stackDequeue.empty()) {
            moveElements()
        }

        return stackDequeue.pop()
    }

    private fun moveElements() {
        while (!stackEnqueue.empty()) {
            stackDequeue.push(stackEnqueue.pop())
        }
    }
}