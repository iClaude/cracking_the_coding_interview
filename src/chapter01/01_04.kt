package chapter01

/*  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    EXAMPLE
    Input: Tact Coa
    Output: True (permutations: "taco cat", "atco eta", etc.)
 */

fun main() {
    println(isPermutationOfPalindrome("cATt   Coa"))
}

private fun isPermutationOfPalindrome(str: String): Boolean {
    if (str.length == 1) return true

    val occurrences = Array(256) { 0 }
    var spaces = 0
    for (char in str) {
        if (char == ' ') {
            spaces++
            continue
        }
        occurrences[char.toLowerCase().toInt()]++
    }

    var evens = 0
    var odds = 0
    for (occ in occurrences) {
        if (occ == 0) continue
        if (occ % 2 == 0) {
            evens++
        } else {
            odds++
        }
    }

    val strLen = str.length - spaces
    return (strLen % 2 == 0 && odds == 0) || (strLen % 2 != 0 && odds == 1)
}