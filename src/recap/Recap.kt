package recap

import java.util.*

fun main() {
    val stack = StackWithSort<Int>().apply {
        push(3)
        push(4)
        push(1)
        push(7)
        push(5)
        pop()
        pop()
    }


}

class StackWithSort<T : Comparable<T>> {
    private val stack = Stack<T>()
    private val stackSorted = Stack<T>()

    fun isEmpty() = stack.isEmpty()

    fun peek() = stack.peek() as T

    fun push(item: T) {
        stack.push(item)

        var i = 0
        while (!stackSorted.isEmpty() && stackSorted.peek() > item) {
            stack.push(stackSorted.pop())
            i++
        }
        stackSorted.push(item)
        repeat(i) {
            stackSorted.push(stack.pop())
        }
    }

    fun pop(): T {
        if (isEmpty()) throw EmptyStackException()

        val item = stack.pop()
        var i = 0
        while (!stackSorted.isEmpty() && stackSorted.peek() != item) {
            stack.push(stackSorted.pop())
            i++
        }
        stackSorted.pop()
        repeat(i) {
            stackSorted.push(stack.pop())
        }

        return item
    }

    fun sort() {
        stack.clear()
        while (!stackSorted.empty()) {
            stack.push(stackSorted.pop())
        }
    }

}


