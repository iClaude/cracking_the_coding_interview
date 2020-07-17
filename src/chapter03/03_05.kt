package chapter03

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