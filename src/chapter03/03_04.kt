package chapter03

/* Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. */

class QueueWithStacks<T> {
    private val stack1 = MyStack<T>()
    private val stack2 = MyStack<T>()

    fun empty() = stack1.empty() && stack2.empty()

    fun enqueue(value: T) {
        stack1.push(value)
    }

    fun dequeue(): T {
        if (empty()) throw Exception("The queue is empty!")

        if (!stack2.empty()) {
            return stack2.pop()
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop())
        }

        return stack2.pop()
    }
}