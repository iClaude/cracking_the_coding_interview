package chapter03

/*
    3.2 How would you design a stack which, in addition to push and pop, also has a function min which
    returns the minimum element? Push, pop and min should all operate in O(1) time.
 */

class StackWithMin<T : Comparable<T>> {
    val stack = Stack<T>()
    val stackMin = Stack<T>()

    fun empty() = stack.empty()

    fun push(key: T) {
        stack.push(key)
        if (stackMin.empty() || key < stackMin.top() as T) {
            stackMin.push(key)
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