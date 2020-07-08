package chapter01

import java.lang.Integer.max

/*
    1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including
    the null character.)

    Let's pretend to represent a C-style string with a CharArray in Kotlin.
 */

fun main() {
    val cString = charArrayOf('a', 'b', 'c', 'd', 'e', '\u0000')
    reverseCString(cString)
    cString.forEach {
        print(it)
    }
}

private fun reverseCString(cString: CharArray) {
    for (i in 0..(cString.size - 1) / 2) {
        swap(cString, i, max((cString.size - 2 - i), i))
    }
}

private fun swap(cString: CharArray, i: Int, j: Int) {
    val dep = cString[i]
    cString[i] = cString[j]
    cString[j] = dep
}