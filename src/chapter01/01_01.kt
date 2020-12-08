package chapter01

/* PROBLEM
   1.1 Implement an algorithm to determine if a string has all unique characters.
   What if you can not use additional data structures? */

/* ALGORITHM 1 - areCharsUnique
   Keep and array of 256 elements, corresponding to each ASCII character, initially set to
   false. For each letter in the original string I set the corresponding element of the
   array to true. If the string contains only unique characters, I must never find an element
   in the control array already set tu true (this would mean that the letter has already been
   found before).
   Performance: O(n)
   ALGORITHM 2 - areCharsUniqueSort
   Not optimal.
   First I sort the characters of the string in ascending order, then I scan the
   sorted string and check that there must not be 2 equal consecutive characters.
   Performance: O(n*logn)
   ALGORITHM 3 - areCharsUniqueDoubleLoop
   Not optimal.
   Compare each character of the string with all subsequent characters.
   Performance: O(n^2) */


val letters = Array(256) { 0 }

fun main() {
    val myString = "abcdefghilmnaopqrstuvwyz"

    println("Characters are unique? -> ${areCharsUnique(myString)}")
    println("Characters are unique? -> ${areCharsUniqueSort(myString)}")
    println("Characters are unique? -> ${areCharsUniqueDoubleLoop(myString)}")
}

private fun areCharsUnique(myString: String): Boolean {
    for (character in myString) {
        letters[character.toInt()]++
        if (letters[character.toInt()] > 1) return false
    }
    return true
}

private fun areCharsUniqueSort(myString: String): Boolean {
    val charsOrdered = myString.toCharArray().sortedArray()
    for (i in 1 until charsOrdered.size) {
        if (charsOrdered[i] == charsOrdered[i - 1]) return false
    }
    return true
}

private fun areCharsUniqueDoubleLoop(myString: String): Boolean {
    for (i in myString.indices) {
        for (j in i + 1 until myString.length) {
            if (myString[i] == myString[j]) return false
        }
    }
    return true
}