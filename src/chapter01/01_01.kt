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


val letters = Array(256) { false }

fun main() {
    val myString = "claudiosn"

    println("Characters are unique? -> ${areCharsUnique(myString)}")
    println("Characters are unique? -> ${areCharsUniqueSort(myString)}")
    println("Characters are unique? -> ${areCharsUniqueDoubleLoop(myString)}")
}

fun areCharsUnique(myString: String): Boolean {
    for (character in myString) {
        if (!letters[character.toInt()]) {
            letters[character.toInt()] = true
        } else {
            return false
        }
    }
    return true
}

fun areCharsUniqueSort(myString: String): Boolean {
    if (myString.length < 2) return true

    val arr = myString.toCharArray()
    val myStringSorted = arr.sorted().joinToString("")

    for (i in 0..myStringSorted.length - 2) {
        if (myStringSorted[i] == myStringSorted[i + 1]) return false
    }

    return true
}

fun areCharsUniqueDoubleLoop(myString: String): Boolean {
    if (myString.length < 2) return true

    for (i in 0..myString.length - 2) {
        for (j in i + 1..myString.length - 1) {
            if (myString[i] == myString[j]) return false
        }
    }

    return true
}