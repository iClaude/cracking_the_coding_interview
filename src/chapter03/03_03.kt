package chapter03

import java.util.*

/*  Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
    composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
    (that is, pop () should return the same values as it would if there were just a single stack).
    FOLLOW UP
    Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack. */

class SetOfStacks<T>(private val capacity: Int) {
    private val stacks = mutableListOf<MyStackPopFirst<T>>()

    fun isEmpty() = stacks.isEmpty()

    fun top(): T {
        if (isEmpty()) throw EmptyStackException()
        return stacks[stacks.lastIndex].top()
    }

    fun push(value: T) {
        if (isEmpty() || stacks[stacks.lastIndex].size == capacity) {
            stacks.add(MyStackPopFirst())
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

        for (i in index until stacks.lastIndex) {
            stacks[i].push(stacks[i + 1].popFirst())
        }

        if (stacks[stacks.lastIndex].empty()) {
            stacks.removeAt(stacks.lastIndex)
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()

        for (stack in stacks) {
            sb.append(stack.toString())
            sb.append("\n")
        }

        return sb.toString()
    }
}

/*
    Implementation of a stack using a doubly linked list with a method to pop the first
    element added to the stack in O(1).
 */

class MyStackPopFirst<T> {
    private var head: LinkedNode<T>? = null
    private var tail: LinkedNode<T>? = null

    var size = 0

    fun push(value: T) {
        val newNode = LinkedNode(value).apply {
            next = head
        }
        head?.prev = newNode
        head = newNode

        if (tail == null) {
            tail = newNode
        }

        size++
    }

    fun top(): T {
        if (empty()) throw EmptyStackException()

        return head!!.value
    }

    fun pop(): T {
        if (empty()) throw EmptyStackException()

        val result = head!!.value
        head = head!!.next
        head?.prev = null

        if (head == null) {
            tail = null
        }

        size--
        return result
    }

    fun popFirst(): T {
        if (empty()) throw EmptyStackException()

        val result = tail!!.value

        if (tail == head) {
            head = null
            tail = null
        } else {
            tail = tail!!.prev
            tail!!.next = null
        }

        size--

        return result
    }

    fun empty() = head == null

    override fun toString(): String {
        val sb = StringBuilder()

        var p = head
        while (p != null) {
            sb.append("${p.value} - ")
            p = p.next
        }

        return sb.toString()
    }

    private class LinkedNode<T>(val value: T) {
        var next: LinkedNode<T>? = null
        var prev: LinkedNode<T>? = null
    }
}
