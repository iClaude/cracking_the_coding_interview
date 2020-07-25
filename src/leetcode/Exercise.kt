package leetcode

import java.util.*

fun main() {
    println(Solution().removeDuplicates("abbaca"))
}

class Solution {
    fun removeDuplicates(S: String): String {
        val stack = Stack<Char>()
        for (char in S) {
            if (!stack.empty() && char == stack.peek()) {
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        return stack.joinToString("")
    }
}
