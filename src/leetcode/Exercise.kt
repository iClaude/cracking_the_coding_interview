package leetcode

fun main() {
    val arr = intArrayOf(4, 7, 9, 11)
    println(Solution().findKthPositive(arr, 10))
}

class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var incr = 0
        var posArray = 0
        var i = 1

        while (incr < k) {
            if (isElementPresent(i, arr, posArray)) {
                posArray++
            } else {
                incr++
            }
            i++
        }

        return i - 1
    }

    private fun isElementPresent(value: Int, arr: IntArray, posArray: Int): Boolean {
        if (posArray !in arr.indices) return false
        return value == arr[posArray]
    }
}
