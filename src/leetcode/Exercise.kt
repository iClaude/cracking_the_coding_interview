package leetcode

import java.util.*
import kotlin.math.abs

class Solution {
    fun makeGood(s: String): String {
        val stack = Stack<Char>()
        s.forEach {
            if (stack.empty() || !badCharacters(it, stack.peek())) {
                stack.push(it)
            } else {
                stack.pop()
            }
        }

        val result = StringBuilder()
        while (!stack.empty()) {
            result.append(stack.pop())
        }
        return result.reverse().toString()
    }

    private fun badCharacters(a: Char, b: Char) =
            abs(a.toInt() - b.toInt()) == 32
}

fun main() {
    val str = "s"

    println(Solution().makeGood(str))
}
