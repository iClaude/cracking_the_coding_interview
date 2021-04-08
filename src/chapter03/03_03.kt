package chapter03

import java.util.*

fun main() {
    val setOfStacks = SetOfStacks<Int>(5).apply {
        push(10)
        push(3)
        push(5)
        push(7)
        push(15)

        push(33)
        push(6)
        push(74)
        push(7)
        push(100)

        push(101)
        push(102)

        println(popAtWithRollover(1))
        println(popAtWithRollover(1))
        println(popAtWithRollover(0))
        println(popAtWithRollover(0))
    }
}

class SetOfStacks<T>(private val capacity: Int) {
    private val stacks = mutableListOf<Stack<T>>()

    fun isEmpty() = stacks.isEmpty()

    fun top(): T {
        if (isEmpty()) throw EmptyStackException()
        return stacks[stacks.lastIndex].peek()
    }

    fun push(value: T) {
        if (isEmpty() || stacks[stacks.lastIndex].size == capacity) {
            stacks.add(Stack())
        }
        stacks[stacks.lastIndex].push(value)
    }

    fun pop(): T {
        if (isEmpty()) throw EmptyStackException()
        val value = stacks[stacks.lastIndex].pop()
        if (stacks[stacks.lastIndex].empty()) {
            stacks.removeAt(stacks.lastIndex)
        }

        return value
    }

    fun popAt(index: Int): T {
        if (index !in stacks.indices) throw ArrayIndexOutOfBoundsException()

        val value = stacks[index].pop()
        if (stacks[index].empty()) {
            stacks.removeAt(index)
        }

        return value
    }

    fun popAtWithRollover(index: Int): T {
        if (index !in stacks.indices) throw ArrayIndexOutOfBoundsException()

        val value = stacks[index].pop()
        rollover(index)

        return value
    }

    private fun rollover(index: Int) {
        if (index == stacks.lastIndex && stacks[stacks.lastIndex].empty()) {
            stacks.removeAt(index)
            return
        }

        val stackCmd = Stack<T>()
        for (i in index until stacks.lastIndex) {
            while (!stacks[index + 1].empty()) {
                stackCmd.push(stacks[index + 1].pop())
            }
            stacks[index].push(stackCmd.pop())
            while (!stackCmd.empty()) {
                stacks[index + 1].push(stackCmd.pop())
            }
        }

        if (stacks[stacks.lastIndex].empty()) {
            stacks.removeAt(stacks.lastIndex)
        }
    }
}
