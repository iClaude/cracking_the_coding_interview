package chapter03

import java.util.*

/*
    3.5 Implement a MyQueue class which implements a queue using two stacks.
 */

class MyQueue<T> {
    private val stackEnqueue = Stack<T>()
    private val stackDequeue = Stack<T>()

    fun empty() = stackEnqueue.empty() && stackDequeue.empty()

    fun enqueue(el: T) {
        stackEnqueue.push(el)
    }

    fun dequeue(): T? {
        if (!stackDequeue.empty()) return stackDequeue.pop()

        if (stackEnqueue.empty()) return null

        while (!stackEnqueue.empty()) {
            stackDequeue.push(stackEnqueue.pop()!!)
        }
        return stackDequeue.pop()
    }
}

// this classes uses the Java Stack class (which throws exceptions if the stack is empty)
class MyQueueB<T> {
    private val stackEnqueue = java.util.Stack<T>()
    private val stackDequeue = java.util.Stack<T>()

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