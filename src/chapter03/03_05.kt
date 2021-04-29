package chapter03

import java.util.*

/*  Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
    an additional temporary stack, but you may not copy the elements into any other data structure
    (such as an array). The stack supports the following operations: push, pop, peek, and is Empty. */

fun main() {
    val stack = Stack<Int>().apply {
        push(6)
        push(5)
        push(9)
        push(1)
        push(22)
        push(3)
    }

    val sortedStack = sortStack(stack)

    println(sortedStack.peek())
}

private fun sortStack(stack: Stack<Int>): Stack<Int> {
    val sortedStack = Stack<Int>()

    while (!stack.isEmpty()) {
        val item = stack.pop()

        var i = 0
        while (!sortedStack.isEmpty() && sortedStack.peek() < item) {
            stack.push(sortedStack.pop())
            i++
        }
        sortedStack.push(item)
        repeat(i) {
            sortedStack.push(stack.pop())
        }
    }

    return sortedStack
}