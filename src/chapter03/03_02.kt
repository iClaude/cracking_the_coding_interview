package chapter03

/*
    3.2 How would you design a stack which, in addition to push and pop, also has a function min which
    returns the minimum element? Push, pop and min should all operate in O(1) time.
 */

// using 2 stacks
class StackWithMin<T : Comparable<T>> {
    private val stack = MyStack<T>()
    private val stackMin = MyStack<T>()

    fun empty() = stack.empty()

    fun push(item: T) {
        stack.push(item)
        if (stackMin.empty() || item < stackMin.top() as T) {
            stackMin.push(item)
        }
    }

    fun top() = stack.top()

    fun pop(): T? {
        val el = stack.pop() ?: return null
        if (el == stackMin.top()) {
            stackMin.pop()
        }

        return el
    }

    fun min() = stackMin.top()
}

// using 1 stack where each element keeps track of the min
class StackWithMinV2<T : Comparable<T>> {
    private val stack = MyStack<Pair<T, T>>()

    fun empty() = stack.empty()

    fun top() = stack.top()?.first

    fun pop() = stack.pop()?.first

    fun push(item: T) {
        val prevMin = stack.top()?.second
        val newMin = if (prevMin == null || item < prevMin) item else prevMin
        stack.push(item to newMin)
    }

    fun min() = stack.top()?.second
}

// test
fun main() {
    val stack = StackWithMinV2<Int>().apply {
        push(12)
        println(min())
        push(24)
        println(min())
        push(7)
        println(min())
        push(8)
        println(min())
        push(1)
        println(min())
        println()

        println(top())
        pop()
        println(min())
        println(top())
        pop()
        println(min())
        println(top())
        pop()
        println(min())
        println(top())
        pop()
        println(min())
        println(top())
        pop()
        println(min())
        println(empty())
    }
}