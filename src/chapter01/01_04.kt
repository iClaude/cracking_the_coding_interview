package chapter01

/*  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    EXAMPLE
    Input: Tact Coa
    Output: True (permutations: "taco cat", "atco eta", etc.)
 */

// TODO: 20/01/2021 redo this exercise after learning bit manipulation
fun main() {
    println(isPalindromePermutation("ottetto"))
}

private fun isPalindromePermutation(str: String): Boolean {
    val evens = Array(256) { true }
    for (char in str) {
        if (char != ' ') {
            evens[char.toLowerCase().toInt()] = !evens[char.toLowerCase().toInt()]
        }
    }

    var numOdds = 0
    for (i in 0..255) {
        if (!evens[i]) {
            numOdds++
            if (numOdds > 1) return false
        }
    }

    return true
}