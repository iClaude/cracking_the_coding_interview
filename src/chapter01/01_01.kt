package chapter01

import java.util.*

/* PROBLEM
   Is Unique: Implement an algorithm to determine if a string has all unique characters.
   What if you cannot use additional data structures? */

fun String.hasUniqueCharacters(): Boolean {
    if (length > 256) return false

    val asciiChars = Array(256) { false }
    for (char in this) {
        if (asciiChars[char.code]) {
            return false
        } else {
            asciiChars[char.code] = true
        }
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

// only for lowercase letters
fun String.hasUniqueCharactersWithBitwiseOperations(): Boolean {
    if (length > 256) return false

    var letters = 0
    for (letter in this) {
        val shift = letter.code - 97
        if ((letters and (1 shl shift)) > 0) {
            return false
        } else {
            letters = letters or (1 shl shift)
        }
    }
    return true
}

fun main() {
    val myString = "abcdefhif"
    println("Has string \"$myString\" all unique characters (hasUniqueCharacters)? ${myString.hasUniqueCharacters()}")
    println("Has string \"$myString\" all unique characters (hasUniqueCharactersWithBitSet)? ${myString.hasUniqueCharactersWithBitSet()}")
    println("Has string \"$myString\" all unique characters (hasUniqueCharactersWithBits)? ${myString.hasUniqueCharactersWithBitwiseOperations()}")

}