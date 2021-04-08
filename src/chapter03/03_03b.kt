package chapter03

/*
    3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds
    some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
    composed of several stacks, and should create a new stack once the previous one exceeds capacity.
    SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop()
    should return the same values as it would if there were just a single stack).
    FOLLOW UP
    Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

/*
class SetOfStacks<T>(private val capacity: Int) {
    private var currentStack = -1

    private val stacks = ArrayList<StackWithSize<T>>()

    fun push(el: T) {
        if (stacks.isEmpty() || stacks[currentStack].size() == capacity) {
            stacks.add(StackWithSize())
            currentStack++
        }
        stacks[currentStack].push(el)
    }

    fun pop(): T? {
        if (stacks.isEmpty()) return null

        val result = stacks[currentStack].pop()
        if (stacks[currentStack].empty()) {
            stacks.removeAt(currentStack)
            currentStack--
        }

        return result
    }

    fun popAt(index: Int): T? {
        if (stacks.isEmpty() || index !in stacks.indices) return null

        val result = stacks[index].pop()
        if (stacks[index].empty()) {
            stacks.removeAt(index)
            currentStack = stacks.size - 1
        }

        return result
    }

    fun popAtWitRollover(index: Int): T? {
        if (stacks.isEmpty() || index !in stacks.indices) return null

        val result = stacks[index].pop()
        if (stacks[index].empty()) {
            stacks.removeAt(index)
            currentStack = stacks.size - 1
        } else {
            for (i in index + 1 until stacks.size) {
                stacks[i - 1].push(stacks[i].popBottom()!!)
                if (stacks[i].empty()) {
                    stacks.removeAt(i)
                    currentStack = stacks.size - 1
                }
            }
        }

        return result
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (i in stacks.indices) {
            sb.append("stack: $i ->")
            sb.append(stacks[i].toString())
        }
        return sb.toString()
    }
}

class StackWithSize<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size = 0

    fun empty() = head == null

    fun size() = size

    fun push(key: T) {
        val newNode = Node(key).apply {
            prev = null
            next = head
        }
        head?.prev = newNode
        if (head == null) tail = newNode
        head = newNode

        size++
    }

    fun top(): T? = head?.key

    fun pop(): T? {
        val result = head?.key
        head = head?.next
        head?.prev = null
        if (head == null) tail = null
        if (result != null) size--

        return result
    }

    fun popBottom(): T? {
        val result = tail?.key
        if (head == tail) {
            head = null
            tail = null
        } else {
            tail = tail?.prev
            tail?.next = null
        }

        return result
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[")
        var p = head
        while (p != null) {
            sb.append(p.key)
            sb.append(",")
            p = p.next
        }
        sb.append("]")

        return sb.toString()
    }

    data class Node<T>(var key: T) {
        var next: Node<T>? = null
        var prev: Node<T>? = null
    }
}*/
