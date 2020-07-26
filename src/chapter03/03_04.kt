package chapter03

/*
    3.4 In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes
    which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from
    top to bottom (e.g., each disk sits on top of an even larger one). You have the following constraints:
    (A) Only one disk can be moved at a time.
    (B) A disk is slid off the top of one rod onto the next rod.
    (C) A disk can only be placed on top of a larger disk.
    Write a program to move the disks from the first rod to the last using Stacks.
 */

fun moveDisks(num: Int, stackOrig: StackHanoi<Int>, stackDest: StackHanoi<Int>, stackTmp: StackHanoi<Int>) {
    // base case
    if (num == 1) {
        stackDest.push(stackOrig.pop()!!)
        return
    } else { // recursive calls
        moveDisks(num - 1, stackOrig, stackTmp, stackDest)
        stackDest.push(stackOrig.pop()!!)
        moveDisks(num - 1, stackTmp, stackDest, stackOrig)
    }
}

/*
    A Stack that doesn't allow to push an element if the top element already in the stack is smaller.
    It also stores the number of elements in the property size.
 */
class StackHanoi<T : Comparable<T>> {
    private var head: Node<T>? = null

    var size = 0

    fun empty() = head == null

    fun push(key: T) {
        if (top() != null && key > top()!!) throw UnsupportedOperationException()

        val newNode = Node(key).apply {
            next = head
        }
        head = newNode

        size++
    }

    fun top(): T? = head?.key

    fun pop(): T? {
        val result = head?.key
        head = head?.next
        if (result != null) size--
        return result
    }

    data class Node<T>(var key: T) {
        var next: Node<T>? = null
    }
}

// test
fun main() {
    val stackOrig = StackHanoi<Int>().apply {
        push(7)
        push(6)
        push(5)
        push(4)
        push(3)
        push(2)
        push(1)
    }
    val stackTmp = StackHanoi<Int>()
    val stackDest = StackHanoi<Int>()

    moveDisks(stackOrig.size, stackOrig, stackDest, stackTmp)

    println("stack orig empty? ${stackOrig.empty()}")
    println("stack tmp empty? ${stackTmp.empty()}")

    println("stack dest: ")
    while (!stackDest.empty()) {
        print("${stackDest.pop()} - ")
    }

}