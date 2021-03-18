package chapter03

import java.util.*
import java.util.Stack
import kotlin.math.min

fun main() {
    println("StackMin test:")
    val stack = StackMin().apply {
        push(7)
        println("min = ${min()}")
        push(1)
        println("min = ${min()}")
        push(5)
        push(4)
        push(3)
        println("min = ${min()}")
        pop()
        println("min = ${peek()}")
        pop()
        println("min = ${peek()}")
        pop()
        println("min = ${min()}")
        pop()
        println("min = ${min()}")
    }

    println("StackMin2 test:")
    val stack2 = StackMin2().apply {
        push(7)
        println("min = ${min()}")
        push(1)
        println("min = ${min()}")
        push(5)
        push(4)
        push(3)
        println("min = ${min()}")
        pop()
        println("min = ${top()}")
        pop()
        println("min = ${top()}")
        pop()
        println("min = ${min()}")
        pop()
        println("min = ${min()}")
    }
}


class StackMin : Stack<Int>() {
    private val minStack = Stack<Int>()

    override fun push(item: Int?): Int {
        item ?: return -1

        if (minStack.isEmpty() || item <= minStack.peek()) {
            minStack.push(item)
        }

        return super.push(item)
    }

    override fun peek(): Int {
        return super.peek()
    }

    override fun pop(): Int {
        val item = super.pop()

        if (item == minStack.peek()) {
            minStack.pop()
        }
        return item
    }

    fun min(): Int {
        if (super.isEmpty()) throw EmptyStackException()
        return minStack.peek()
    }
}

class StackMin2 {
    private val stack = Stack<Pair<Int, Int>>()

    fun push(value: Int) {
        val min = if (stack.isEmpty()) {
            value
        } else {
            min(value, stack.peek().second)
        }

        stack.push(value to min)
    }

    fun top(): Int {
        if (stack.isEmpty()) throw EmptyStackException()
        return stack.peek().first
    }

    fun pop(): Int {
        if (stack.isEmpty()) throw EmptyStackException()
        return stack.pop().first
    }

    fun min(): Int {
        if (stack.isEmpty()) throw EmptyStackException()
        return stack.peek().second
    }

    fun empty() = stack.isEmpty()
}