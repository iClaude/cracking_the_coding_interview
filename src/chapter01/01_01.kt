package chapter01

import java.util.*

/* Is Unique: Implement an algorithm to determine if a string has all unique characters.
   What if you cannot use additional data structures? */

private fun hasUniqueCharactersWithArray(str: String): Boolean {
    if (str.length > 256) return false

    val chars = Array(256) { false }

    for (char in str) {
        if (chars[char.code]) {
            return false
        }
        chars[char.code] = true
    }

    return true
}

private fun hasUniqueCharactersWithMap(str: String): Boolean {
    if (str.length > 256) return false

    val chars = hashMapOf<Char, Boolean>()

    for (char in str) {
        if (chars[char] == true) {
            return false
        }
        chars[char] = true
    }

    return true
}

private fun hasUniqueCharactersWithSorting(str: String): Boolean {
    if (str.length > 256) return false

    val strSorted = str.toCharArray().sorted()
    for (i in 0..strSorted.size - 2) {
        if (strSorted[i] == strSorted[i + 1]) {
            return false
        }
    }

    return true
}

private fun hasUniqueCharactersWithBits(str: String): Boolean {
    var chars: Int = 0

    for (char in str) {
        val pos = char.code - 97
        if ((1 shl (pos) and chars) > 0) {
            return false
        }
        chars = 1 shl (pos) or chars
    }

    return true
}

fun String.hasUniqueCharactersWithBitSet(): Boolean {
    if (length > 256) return false

    val asciiChars = BitSet(256)
    for (char in this) {
        if (asciiChars[char.code]) {
            return false
        } else {
            asciiChars[char.code] = true
        }
    }
    return true
}

fun main() {
    val mStr = "abcdefghie"
    println(hasUniqueCharactersWithArray(mStr))
    println(hasUniqueCharactersWithMap(mStr))
    println(hasUniqueCharactersWithSorting(mStr))
    println(hasUniqueCharactersWithBits(mStr))
    println(mStr.hasUniqueCharactersWithBitSet())
}