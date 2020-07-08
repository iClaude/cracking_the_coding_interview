package chapter01

/*
   PROBLEM
   1.3 Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
   NOTE: One or two additional variables are fine. An extra copy of the array is not.
   FOLLOW UP
   Write the test cases for this method.

   ALGORITHM 1 (removeDuplicates)
   Use a control array to keep track of the number of occurences of each letter, then use this array to rearrange the original
   string skipping the duplicate characters.
   Performance: O(n)

   ALGORITHM 2 (removeDuplicates2)
   Scan the string and for each character check if it was already added to string. If not, add it to the string; if yes, skip it.
   Performance: O(n^2)

   ALGORITHM 3 (removeDuplicates3)
   Iterate over the string and consider each character. If the character was previously considered, skip it, otherwise add it to
   the string. To know if a character has already been added, keep a control boolean array of 256 elements, where we store if
   that particular character has already been added to the string.
   Performance: O(n)
*/

fun main() {
    val str = "aaabbbcdeeefffg"
    println("str: $str")
    removeDuplicates(str)
    println("str without duplicates: ${removeDuplicates(str)}")
}

private fun removeDuplicates(str: String): String {
    val chars = Array(256) { 0 }
    for (char in str) {
        chars[char.toInt()]++
    }

    // let's pretend to represent the string with a char array (in Kotlin Strings are immutable!)
    val strArr = str.toCharArray()
    var offset = 0
    for (i in strArr.indices) {
        val char = strArr[i]
        when (chars[char.toInt()]) {
            1 -> {
                strArr[i - offset] = char
            }
            in 2..Int.MAX_VALUE -> {
                strArr[i - offset] = char
                chars[char.toInt()] = -1
            }
            -1 -> {
                offset++
            }
        }
    }
    for (i in strArr.size - offset until strArr.size) {
        strArr[i] = ' '
    }

    return strArr.joinToString("")
}

private fun removeDuplicates2(str: String): String {
    val strArr = str.toCharArray()
    var pointer = 0
    for (i in strArr.indices) {
        var found = false
        for (j in 0 until i) {
            if (strArr[i] == strArr[j]) {
                found = true
                break
            }
        }
        if (!found) {
            strArr[pointer++] = strArr[i]
        }
    }

    for (i in pointer..strArr.size - 1) {
        strArr[i] = ' '
    }

    return strArr.joinToString("")
}

private fun removeDuplicates3(str: String): String {
    val charsHit = Array(256) { false }

    val strArr = str.toCharArray()
    var pointer = 0
    for (i in strArr.indices) {
        val char = strArr[i]
        if (!charsHit[char.toInt()]) {
            strArr[pointer++] = char
            charsHit[char.toInt()] = true
        }
    }

    for (i in pointer until strArr.size) {
        strArr[i] = ' '
    }

    return strArr.joinToString("")
}