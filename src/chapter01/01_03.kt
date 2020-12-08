package chapter01

/*
   PROBLEM
   1.3 Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
   NOTE: One or two additional variables are fine. An extra copy of the array is not.
   FOLLOW UP
   Write the test cases for this method.

   ALGORITHM
   Iterate over the string and consider each character. If the character was previously considered, skip it, otherwise add it to
   the string. To know if a character has already been added, keep a control boolean array of 256 elements, where we store if
   that particular character has already been added to the string.
   Performance: O(n)
*/

fun main() {
    val str = "aaabbbcdeeefffg"
    println("str: $str")
    println("str without duplicates: ${removeDuplicates(str)}")
}

fun removeDuplicates(str: String): String {
    val strResult = StringBuilder()
    val charsHit = Array(256) { false }
    for (char in str) {
        if (!charsHit[char.toInt()]) {
            charsHit[char.toInt()] = true
            strResult.append(char)
        } else {
            continue
        }
    }
    return strResult.toString()
}