package chapter03

import chapter03.Stacks.*
import java.util.*

enum class Stacks { ONE, TWO, THREE }

class ThreeStacksEqualSize(capacity: Int) {
    private val totalCapacity = capacity * 3
    private val mArray = IntArray(totalCapacity)

    private val starts = intArrayOf(0, totalCapacity / 3, totalCapacity * 2 / 3)
    private val ends = intArrayOf(totalCapacity / 3 - 1, totalCapacity * 2 / 3 - 1, totalCapacity - 1)
    private val indices = Array(3) { starts[it] - 1 }

    fun push(value: Int, stack: Stacks) {
        if (indices[stack.ordinal] + 1 > ends[stack.ordinal]) throw EmptyStackException()
        indices[stack.ordinal]++
        mArray[indices[stack.ordinal]] = value
    }

    fun top(stack: Stacks): Int {
        if (indices[stack.ordinal] !in starts[stack.ordinal]..ends[stack.ordinal]) throw EmptyStackException()
        return mArray[indices[stack.ordinal]]
    }

    fun pop(stack: Stacks): Int {
        if (indices[stack.ordinal] !in starts[stack.ordinal]..ends[stack.ordinal]) throw EmptyStackException()
        val result = mArray[indices[stack.ordinal]]
        indices[stack.ordinal]--

        return result
    }

    fun empty(stack: Stacks) = indices[stack.ordinal] < starts[stack.ordinal]
}

class ThreeStacksFlexibleWithPointers(size: Int) {
    private val mSize = size * 3
    private val mArray = Array(mSize) { Integer.MIN_VALUE to -1 }
    private val starts = intArrayOf(-1, -1, -1)
    private var pos = 0

    fun push(value: Int, stack: Stacks) {
        var foundSpot = false
        for (i in pos + 1 until mSize) {
            if (mArray[i].first == Integer.MIN_VALUE) {
                foundSpot = true
                pos = i
                break
            }
        }
        if (!foundSpot) {
            for (i in 0 until pos) {
                if (mArray[i].first == Integer.MIN_VALUE) {
                    foundSpot = true
                    pos = i
                    break
                }
            }
        }

        if (!foundSpot) throw EmptyStackException()
        mArray[pos] = value to starts[stack.ordinal]
        starts[stack.ordinal] = pos
    }

    fun top(stack: Stacks): Int {
        if (starts[stack.ordinal] == -1) throw EmptyStackException()
        return mArray[starts[stack.ordinal]].first
    }

    fun pop(stack: Stacks): Int {
        if (starts[stack.ordinal] == -1) throw EmptyStackException()

        val result = mArray[starts[stack.ordinal]].first
        starts[stack.ordinal] = mArray[starts[stack.ordinal]].second

        return result
    }

    fun empty(stack: Stacks) = starts[stack.ordinal] == -1
}

class ThreeStacksFlexibleNoPointers(capacity: Int) {
    private val totalCapacity = capacity * 3

    private class StackInfo(var size: Int = 0, var capacity: Int = 0, var firstIndex: Int = 0, var lastIndex: Int = 0) {
        fun isFull() = size == capacity
        fun isEmpty() = size == 0
    }

    private val backingArray = Array(totalCapacity) { Integer.MIN_VALUE }

    private val stacks = Array(3) { stackNum ->
        StackInfo(0, capacity, stackNum * capacity, (stackNum + 1) * capacity - 1)
    }

    fun isEmpty(stack: Stacks) = stacks[stack.ordinal].size == 0

    fun top(stack: Stacks): Int {
        val stackInfo = stacks[stack.ordinal]
        if (stackInfo.isEmpty()) throw EmptyStackException()

        return backingArray[stackInfo.firstIndex + stackInfo.size - 1]
    }

    fun pop(stack: Stacks): Int {
        val stackInfo = stacks[stack.ordinal]
        if (stackInfo.isEmpty()) throw EmptyStackException()

        val result = backingArray[stackInfo.firstIndex + stackInfo.size - 1]
        stackInfo.size--

        return result
    }

    fun push(value: Int, stack: Stacks) {
        if (stacks[ONE.ordinal].isFull() && stacks[TWO.ordinal].isFull() && stacks[THREE.ordinal].isFull()) {
            throw EmptyStackException()
        }

        val stackInfoCurr = stacks[stack.ordinal]
        if (!stackInfoCurr.isFull()) {
            backingArray[stackInfoCurr.firstIndex + stackInfoCurr.size] = value
            stackInfoCurr.size++
            return
        }

        val stackInfoNext = stacks[(stack.ordinal + 1) % 3]
        if (!stackInfoNext.isFull()) {
            pushIntoNext(stackInfoCurr, stackInfoNext, value)
            return
        }

        val prev = if (stack.ordinal - 1 >= 0) stack.ordinal - 1 else 2
        pushIntoPrevious(stackInfoCurr, stacks[prev], value)
    }

    private fun pushIntoNext(stackInfoOrig: StackInfo, stackInfoDest: StackInfo, value: Int) {
        for (i in stackInfoDest.firstIndex + stackInfoDest.size - 1 downTo stackInfoDest.firstIndex) {
            backingArray[i + 1] = backingArray[i]
        }
        stackInfoDest.apply {
            capacity--
            firstIndex++
        }
        stackInfoOrig.apply {
            size++
            capacity++
            lastIndex = (lastIndex + 1) % totalCapacity
        }
        backingArray[stackInfoOrig.lastIndex] = value
    }

    private fun pushIntoPrevious(stackInfoOrig: StackInfo, stackInfoDest: StackInfo, value: Int) {
        for (i in stackInfoOrig.firstIndex..stackInfoOrig.lastIndex) {
            val index = if (i - 1 >= 0) i - 1 else totalCapacity - 1 - i
            backingArray[index] = backingArray[i]
        }
        stackInfoOrig.apply {
            size++
            capacity++
            firstIndex = stackInfoDest.lastIndex
        }
        stackInfoDest.apply {
            capacity--
            lastIndex--
        }
        backingArray[stackInfoOrig.lastIndex] = value
    }
}