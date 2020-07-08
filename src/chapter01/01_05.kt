package chapter01

/* PROBLEM
   1.5 Write a method to replace all spaces in a string with ‘%20’. */

/* ALGORITHM
   Count the number of spaces in the original string.
   Create an array of characters of the final size: size of the original string + number of spaces
   * 2 (to make room for %20).
   Loop over the original string and copy each character in the new array, or %20 in case of spaces,
   incrementing an index to keep track of the position in the new array.
   Finally convert the array in a string.
 */

fun main() {
    val str1 = " a bc  d "
    println("new string -> ${replaceSpaces(str1)}")
}

private fun replaceSpaces(str1: String): String {
    var spaces = 0
    for (char in str1) {
        if (char == ' ') spaces++
    }
    val newLen = str1.length + spaces * 2

    val newStrArr = Array(newLen) { ' ' }
    var i = 0
    for (char in str1) {
        if (char != ' ') {
            newStrArr[i++] = char
        } else {
            newStrArr[i++] = '%'
            newStrArr[i++] = '2'
            newStrArr[i++] = '0'
        }
    }

    return newStrArr.joinToString("")
}