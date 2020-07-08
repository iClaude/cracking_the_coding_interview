package chapter01

/* PROBLEM
   1.4 Write a method to decide if two strings are anagrams or not (permutations). */

/* ALGORITHM
   First of all, let's check that the two strings have equal length: if the lengths are not
   equal they can't be anagrams.
   Two strings are anagrams (permutations) if they have the same characters in the same amount,
   just in a different order.
   We keep an array of characters with 256 elements (ASCII characters), initially set to 0. This
   array shows, for each character, how many times that particular character is present in our
   strings.
   We scan string1 and update the array. Then we scan string2: for each character we decrement the
   amount corresponding to the character in our control array. If we obtain -1, string2 has more
   occurrences of that particular character. Therefore the two strings can't be anagrams.
   If we arrive at the end without errors that means that the two strings are actually anagrams:
   the control array becomes 0.
   Performance: O(n), where n is: string1 charaters + string2 characters. */



fun main() {
    val str1 = "sarnia9"
    val str2 = "9riyaas"
    println("are the 2 strings anagrams? -> ${areAnagrams(str1, str2)}")
}

private fun areAnagrams(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val checkArray = Array(256) { 0 }
    for (char in str1) {
        checkArray[char.toInt()]++
    }
    for (char in str2) {
        checkArray[char.toInt()]--
        if (checkArray[char.toInt()] < 0) return false
    }
    return true
}