package chapter03

/*
    3.6 Write a program to sort a stack in ascending order. You should not make any assumptions
    about how the stack is implemented. The following are the only functions that should be used
    to write this program: push | pop | peek | isEmpty.
 */

fun orderStack(stack: MyStack<Int>): MyStack<Int> {
    val stackResult = MyStack<Int>()
    while (!stack.empty()) {
        val el = stack.pop()!!

        while (!stackResult.empty() && stackResult.top()!! < el) {
            stack.push(stackResult.pop()!!)
        }
        stackResult.push(el)
    }

    return stackResult
}
